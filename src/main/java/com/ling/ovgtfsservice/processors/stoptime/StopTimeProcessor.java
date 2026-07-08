package com.ling.ovgtfsservice.processors.stoptime;

import com.ling.ovgtfsservice.GtfsProcessor;
import com.ling.ovgtfsservice.GtfsType;
import org.apache.commons.csv.CSVRecord;

public class StopTimeProcessor implements GtfsProcessor {

    @Override
    public GtfsType type() {
        return GtfsType.TRIPS;
    }

    @Override
    public String topic() {
        return "gtfs.stoptimes";
    }

    @Override
    public Object parse(CSVRecord csv) {
        return StopTimeDto.fromCSV(csv);
    }
}
