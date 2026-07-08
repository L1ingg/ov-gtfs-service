package com.ling.ovgtfsservice.processors.transfer;

import org.apache.commons.csv.CSVRecord;

public record TransferDto(
        String fromStopId,
        String toStopId,
        String fromRouteId,
        String toRouteId,
        String fromTripId,
        String toTripId,
        String transferType,
        String minTransferTime
) {

    public static TransferDto fromCSV(CSVRecord r) {
        return new TransferDto(
                r.get("from_stop_id"),
                r.get("to_stop_id"),
                r.get("from_route_id"),
                r.get("to_route_id"),
                r.get("from_trip_id"),
                r.get("to_trip_id"),
                r.get("transfer_type"),
                r.get("min_transfer_time")
        );
    }
}