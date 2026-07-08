package com.ling.ovgtfsservice.processors.route;

import org.apache.commons.csv.CSVRecord;

public record RouteDto(
        String routeId,
        String agencyId,
        String shortName,
        String longName,
        String description,
        String routeType,
        String color,
        String textColor,
        String url
) {

    public static RouteDto fromCSV(CSVRecord r) {
        return new RouteDto(
                r.get("route_id"),
                r.get("agency_id"),
                r.get("route_short_name"),
                r.get("route_long_name"),
                r.get("route_desc"),
                r.get("route_type"),
                r.get("route_color"),
                r.get("route_text_color"),
                r.get("route_url")
        );
    }
}