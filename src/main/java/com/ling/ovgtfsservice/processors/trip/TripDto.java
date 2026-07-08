package com.ling.ovgtfsservice.processors.trip;

import org.apache.commons.csv.CSVRecord;

public record TripDto(
        String routeId,
        String serviceId,
        String tripId,
        String realtimeTripId,
        String headsign,
        String shortName,
        String longName,
        String directionId,
        String blockId,
        String shapeId,
        String wheelchairAccessible,
        String bikesAllowed
) {

    public static TripDto fromCSV(CSVRecord r) {
        return new TripDto(
                r.get("route_id"),
                r.get("service_id"),
                r.get("trip_id"),
                r.get("realtime_trip_id"),
                r.get("trip_headsign"),
                r.get("trip_short_name"),
                r.get("trip_long_name"),
                r.get("direction_id"),
                r.get("block_id"),
                r.get("shape_id"),
                r.get("wheelchair_accessible"),
                r.get("bikes_allowed")
        );
    }
}