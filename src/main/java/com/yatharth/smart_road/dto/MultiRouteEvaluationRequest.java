package com.yatharth.smart_road.dto;

import java.util.List;

public class MultiRouteEvaluationRequest {

    private List<CandidateRouteInput> candidateRoutes;
    private Double maxProximityMeters;

    public MultiRouteEvaluationRequest() {}

    public MultiRouteEvaluationRequest(List<CandidateRouteInput> candidateRoutes, Double maxProximityMeters) {
        this.candidateRoutes = candidateRoutes;
        this.maxProximityMeters = maxProximityMeters;
    }

    public List<CandidateRouteInput> getCandidateRoutes() {
        return candidateRoutes;
    }

    public void setCandidateRoutes(List<CandidateRouteInput> candidateRoutes) {
        this.candidateRoutes = candidateRoutes;
    }

    public Double getMaxProximityMeters() {
        return maxProximityMeters != null ? maxProximityMeters : 350.0;
    }

    public void setMaxProximityMeters(Double maxProximityMeters) {
        this.maxProximityMeters = maxProximityMeters;
    }

    public static class CandidateRouteInput {
        private String routeId;
        private String title;
        private List<double[]> coordinates;
        private String distance;
        private String duration;

        public CandidateRouteInput() {}

        public CandidateRouteInput(String routeId, String title, List<double[]> coordinates, String distance, String duration) {
            this.routeId = routeId;
            this.title = title;
            this.coordinates = coordinates;
            this.distance = distance;
            this.duration = duration;
        }

        public String getRouteId() {
            return routeId;
        }

        public void setRouteId(String routeId) {
            this.routeId = routeId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<double[]> getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(List<double[]> coordinates) {
            this.coordinates = coordinates;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }
    }
}
