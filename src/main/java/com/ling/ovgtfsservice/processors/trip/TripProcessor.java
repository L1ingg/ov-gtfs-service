package com.ling.ovgtfsservice.processors.trip;

import com.ling.ovgtfsservice.GtfsProcessor;
import com.ling.ovgtfsservice.GtfsType;
import org.apache.commons.csv.CSVRecord;

public class TripProcessor implements GtfsProcessor {

    @Override
    public GtfsType type() {
        return GtfsType.TRIPS;
    }

    @Override
    public String topic() {
        return "gtfs.trips";
    }

    @Override
    public Object parse(CSVRecord csv) {
        return TripDto.fromCSV(csv);
    }
}
