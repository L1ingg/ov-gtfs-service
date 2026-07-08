package com.ling.ovgtfsservice.processors.feed;

import com.ling.ovgtfsservice.GtfsProcessor;
import com.ling.ovgtfsservice.GtfsType;
import org.apache.commons.csv.CSVRecord;

public class FeedProcessor implements GtfsProcessor {

    @Override
    public GtfsType type() {
        return GtfsType.TRIPS;
    }

    @Override
    public String topic() {
        return "gtfs.feedinfo";
    }

    @Override
    public Object parse(CSVRecord csv) {
        return FeedDto.fromCSV(csv);
    }
}
