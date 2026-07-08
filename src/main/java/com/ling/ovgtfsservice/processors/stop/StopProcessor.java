package com.ling.ovgtfsservice.processors.stop;

import com.ling.ovgtfsservice.GtfsProcessor;
import com.ling.ovgtfsservice.GtfsType;
import org.apache.commons.csv.CSVRecord;

public class StopProcessor implements GtfsProcessor {

    @Override
    public GtfsType type() {
        return GtfsType.TRIPS;
    }

    @Override
    public String topic() {
        return "gtfs.stops";
    }

    @Override
    public Object parse(CSVRecord csv) {
        return StopDto.fromCSV(csv);
    }
}
