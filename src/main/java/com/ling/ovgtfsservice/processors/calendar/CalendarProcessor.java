package com.ling.ovgtfsservice.processors.calendar;

import com.ling.ovgtfsservice.GtfsProcessor;
import com.ling.ovgtfsservice.GtfsType;
import org.apache.commons.csv.CSVRecord;

public class CalendarProcessor implements GtfsProcessor {

    @Override
    public GtfsType type() {
        return GtfsType.TRIPS;
    }

    @Override
    public String topic() {
        return "gtfs.calendardates";
    }

    @Override
    public Object parse(CSVRecord csv) {
        return CalendarDto.fromCSV(csv);
    }
}
