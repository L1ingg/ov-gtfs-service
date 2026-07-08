package com.ling.ovgtfsservice.processors.transfer;

import com.ling.ovgtfsservice.GtfsProcessor;
import com.ling.ovgtfsservice.GtfsType;
import org.apache.commons.csv.CSVRecord;

public class TransferProcessor implements GtfsProcessor {

    @Override
    public GtfsType type() {
        return GtfsType.TRANSFERS;
    }

    @Override
    public String topic() {
        return "gtfs.transfers";
    }

    @Override
    public Object parse(CSVRecord csv) {
        return TransferDto.fromCSV(csv);
    }
}
