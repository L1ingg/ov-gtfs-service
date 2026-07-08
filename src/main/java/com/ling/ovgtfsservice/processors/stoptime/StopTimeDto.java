package com.ling.ovgtfsservice.processors.stoptime;

import org.apache.commons.csv.CSVRecord;

public record StopTimeDto(
        String tripId,
        String stopSequence,
        String stopId,
        String stopHeadsign,
        String arrivalTime,
        String departureTime,
        String pickupType,
        String dropOffType,
        String timepoint,
        String shapeDistTraveled,
        String fareUnitsTraveled
) {

    public static StopTimeDto fromCSV(CSVRecord r) {
        return new StopTimeDto(
                r.get("trip_id"),
                r.get("stop_sequence"),
                r.get("stop_id"),
                r.get("stop_headsign"),
                r.get("arrival_time"),
                r.get("departure_time"),
                r.get("pickup_type"),
                r.get("drop_off_type"),
                r.get("timepoint"),
                r.get("shape_dist_traveled"),
                r.get("fare_units_traveled")
        );
    }
}