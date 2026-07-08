package com.ling.ovgtfsservice;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class GtfsService {

    private final GtfsDownloader downloader;
    private final ApplicationEventPublisher publisher;

    public GtfsService(GtfsDownloader downloader, ApplicationEventPublisher publisher) {
        this.downloader = downloader;
        this.publisher = publisher;
    }

                         // 0 0 3 * * *
//    @Scheduled(cron = "${parser.cron}")
    public void parse() {

        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setTrim(true)
                .get();

        Path path = Path.of("resources/gtfs-nl.zip");

        try (ZipInputStream zip = new ZipInputStream(
                Files.exists(path) ? Files.newInputStream(path) : downloader.downloadZip().body().asInputStream()
        )) {

            for (ZipEntry entry; (entry = zip.getNextEntry()) != null; ) {
                if (entry.isDirectory() || GtfsType.fromValue(entry.getName()).equals(GtfsType.STOP_TIMES)) {
                    continue;
                }

                InputStream shield = new FilterInputStream(zip) {
                    @Override
                    public void close() {
                        // intentionally empty
                    }
                };

                try (Reader reader = new InputStreamReader(shield, StandardCharsets.UTF_8);
                     CSVParser parser = CSVParser.parse(reader, format)) {

                    for (CSVRecord r : parser) {
                        publisher.publishEvent(
                                new OnGtfsUpdate(
                                        GtfsType.fromValue(entry.getName()),
                                        r
                                )
                        );
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onReady() {
        parse();
    }

}
