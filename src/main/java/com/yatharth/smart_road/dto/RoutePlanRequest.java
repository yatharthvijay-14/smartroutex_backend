package com.yatharth.smart_road.dto;

public class RoutePlanRequest {

    private Double startLat;
    private Double startLng;
    private Double endLat;
    private Double endLng;
    private Double maxProximityMeters; // Optional distance threshold (default 500m)

    public RoutePlanRequest() {
    }

    public RoutePlanRequest(Double startLat, Double startLng, Double endLat, Double endLng, Double maxProximityMeters) {
        this.startLat = startLat;
        this.startLng = startLng;
        this.endLat = endLat;
        this.endLng = endLng;
        this.maxProximityMeters = maxProximityMeters;
    }

    public Double getStartLat() {
        return startLat;
    }

    public void setStartLat(Double startLat) {
        this.startLat = startLat;
    }

    public Double getStartLng() {
        return startLng;
    }

    public void setStartLng(Double startLng) {
        this.startLng = startLng;
    }

    public Double getEndLat() {
        return endLat;
    }

    public void setEndLat(Double endLat) {
        this.endLat = endLat;
    }

    public Double getEndLng() {
        return endLng;
    }

    public void setEndLng(Double endLng) {
        this.endLng = endLng;
    }

    public Double getMaxProximityMeters() {
        return maxProximityMeters != null ? maxProximityMeters : 500.0;
    }

    public void setMaxProximityMeters(Double maxProximityMeters) {
        this.maxProximityMeters = maxProximityMeters;
    }
}
