package com.ling.ovgtfsservice.processors.stop;

import org.apache.commons.csv.CSVRecord;

public record StopDto(
        String id,
        String code,
        String name,
        String lat,
        String lon,
        String locationType,
        String parentStation,
        String timezone,
        String wheelchairBoarding,
        String platformCode,
        String zoneId
) {

    public static StopDto fromCSV(CSVRecord r) {
        return new StopDto(
                r.get("stop_id"),
                r.get("stop_code"),
                r.get("stop_name"),
                r.get("stop_lat"),
                r.get("stop_lon"),
                r.get("location_type"),
                r.get("parent_station"),
                r.get("stop_timezone"),
                r.get("wheelchair_boarding"),
                r.get("platform_code"),
                r.get("zone_id")
        );
    }
}