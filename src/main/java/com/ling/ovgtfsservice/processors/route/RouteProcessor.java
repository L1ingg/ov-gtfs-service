package com.ling.ovgtfsservice.processors.route;

import com.ling.ovgtfsservice.GtfsProcessor;
import com.ling.ovgtfsservice.GtfsType;
import org.apache.commons.csv.CSVRecord;

public class RouteProcessor implements GtfsProcessor {

    @Override
    public GtfsType type() {
        return GtfsType.TRIPS;
    }

    @Override
    public String topic() {
        return "gtfs.routes";
    }

    @Override
    public Object parse(CSVRecord csv) {
        return RouteDto.fromCSV(csv);
    }
}
