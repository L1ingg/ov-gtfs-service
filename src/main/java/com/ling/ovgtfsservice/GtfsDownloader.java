package com.ling.ovgtfsservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "fileClient", url = "${gtfs.url}")
public interface GtfsDownloader {

    @GetMapping(value = "/gtfs-nl.zip", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    feign.Response downloadZip();
}
