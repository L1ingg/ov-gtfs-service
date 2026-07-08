package com.ling.ovgtfsservice.processors.shape;

import com.ling.ovgtfsservice.GtfsProcessor;
import com.ling.ovgtfsservice.GtfsType;
import org.apache.commons.csv.CSVRecord;

public class ShapeProcessor implements GtfsProcessor {

    @Override
    public GtfsType type() {
        return GtfsType.TRIPS;
    }

    @Override
    public String topic() {
        return "gtfs.shapes";
    }

    @Override
    public Object parse(CSVRecord csv) {
        return ShapeDto.fromCSV(csv);
    }
}
