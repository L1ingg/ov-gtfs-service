package com.ling.ovgtfsservice.processors.calendar;

import org.apache.commons.csv.CSVRecord;

public record CalendarDto(
        String serviceId,
        String date,
        String exceptionType
) {

    public static CalendarDto fromCSV(CSVRecord r) {
        return new CalendarDto(
                r.get("service_id"),
                r.get("date"),
                r.get("exception_type")
        );
    }
}