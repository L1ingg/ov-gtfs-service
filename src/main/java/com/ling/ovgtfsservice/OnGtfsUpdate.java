package com.ling.ovgtfsservice;

import org.apache.commons.csv.CSVRecord;

public record OnGtfsUpdate(GtfsType type, CSVRecord record) {
}
