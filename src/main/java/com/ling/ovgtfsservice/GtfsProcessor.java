package com.ling.ovgtfsservice;

import org.apache.commons.csv.CSVRecord;

public interface GtfsProcessor {
    GtfsType type();
    String topic();
    Object parse(CSVRecord csv);
}
