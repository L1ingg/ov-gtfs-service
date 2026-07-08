package com.ling.ovgtfsservice.processors.shape;

import org.apache.commons.csv.CSVRecord;

public record ShapeDto(
        String shapeId,
        String shapePtSequence,
        String shapePtLat,
        String shapePtLon,
        String shapeDistTraveled
) {

    public static ShapeDto fromCSV(CSVRecord r) {
        return new ShapeDto(
                r.get("shape_id"),
                r.get("shape_pt_sequence"),
                r.get("shape_pt_lat"),
                r.get("shape_pt_lon"),
                r.get("shape_dist_traveled")
        );
    }
}