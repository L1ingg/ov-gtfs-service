package com.ling.ovgtfsservice.processors.agency;

import com.ling.ovgtfsservice.GtfsProcessor;
import com.ling.ovgtfsservice.GtfsType;
import org.apache.commons.csv.CSVRecord;

public class AgencyProcessor implements GtfsProcessor {

    @Override
    public GtfsType type() {
        return GtfsType.TRIPS;
    }

    @Override
    public String topic() {
        return "gtfs.agency";
    }

    @Override
    public Object parse(CSVRecord csv) {
        return AgencyDto.fromCSV(csv);
    }
}
