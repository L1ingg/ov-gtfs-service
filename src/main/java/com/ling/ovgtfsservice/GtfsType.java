package com.ling.ovgtfsservice;

public enum GtfsType {
    STOP_TIMES("stop_times.txt"),
    AGENCY("agency.txt"),
    FEED_INFO("feed_info.txt"),
    SHAPES("shapes.txt"),
    TRANSFERS("transfers.txt"),
    CALENDAR_DATES("calendar_dates.txt"),
    STOPS("stops.txt"),
    TRIPS("trips.txt"),
    ROUTES("routes.txt");

    private final String value;

    GtfsType(String value) {
        this.value = value;
    }

    public static GtfsType fromValue(String value) {
        for (GtfsType type : values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException(
                "Unknown value: " + value
        );
    }
}
