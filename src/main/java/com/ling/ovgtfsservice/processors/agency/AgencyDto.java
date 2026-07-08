package com.ling.ovgtfsservice.processors.agency;

import org.apache.commons.csv.CSVRecord;

public record AgencyDto(
        String agencyId,
        String agencyName,
        String agencyUrl,
        String agencyTimezone,
        String agencyPhone
) {

    public static AgencyDto fromCSV(CSVRecord r) {
        return new AgencyDto(
                r.get("agency_id"),
                r.get("agency_name"),
                r.get("agency_url"),
                r.get("agency_timezone"),
                r.get("agency_phone")
        );
    }
}