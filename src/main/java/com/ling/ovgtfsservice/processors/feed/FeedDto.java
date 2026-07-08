package com.ling.ovgtfsservice.processors.feed;

import org.apache.commons.csv.CSVRecord;

public record FeedDto(
        String feedPublisherName,
        String feedId,
        String feedPublisherUrl,
        String feedLang,
        String feedStartDate,
        String feedEndDate,
        String feedVersion
) {

    public static FeedDto fromCSV(CSVRecord r) {
        return new FeedDto(
                r.get("feed_publisher_name"),
                r.get("feed_id"),
                r.get("feed_publisher_url"),
                r.get("feed_lang"),
                r.get("feed_start_date"),
                r.get("feed_end_date"),
                r.get("feed_version")
        );
    }
}