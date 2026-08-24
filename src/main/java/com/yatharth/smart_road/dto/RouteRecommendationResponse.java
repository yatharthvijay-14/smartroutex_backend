package com.yatharth.smart_road.dto;

import com.yatharth.smart_road.entity.Road;
import java.util.List;

public class RouteRecommendationResponse {

    private List<Road> recommendedRoads; // status = LOW
    private List<Road> cautionRoads;     // status = MEDIUM
    private List<Road> avoidRoads;       // status = HIGH
    private Double safetyScore;
    private String advisoryMessage;

    public RouteRecommendationResponse() {
    }

    public RouteRecommendationResponse(List<Road> recommendedRoads, List<Road> cautionRoads, List<Road> avoidRoads, Double safetyScore, String advisoryMessage) {
        this.recommendedRoads = recommendedRoads;
        this.cautionRoads = cautionRoads;
        this.avoidRoads = avoidRoads;
        this.safetyScore = safetyScore;
        this.advisoryMessage = advisoryMessage;
    }

    public List<Road> getRecommendedRoads() {
        return recommendedRoads;
    }

    public void setRecommendedRoads(List<Road> recommendedRoads) {
        this.recommendedRoads = recommendedRoads;
    }

    public List<Road> getCautionRoads() {
        return cautionRoads;
    }

    public void setCautionRoads(List<Road> cautionRoads) {
        this.cautionRoads = cautionRoads;
    }

    public List<Road> getAvoidRoads() {
        return avoidRoads;
    }

    public void setAvoidRoads(List<Road> avoidRoads) {
        this.avoidRoads = avoidRoads;
    }

    public Double getSafetyScore() {
        return safetyScore;
    }

    public void setSafetyScore(Double safetyScore) {
        this.safetyScore = safetyScore;
    }

    public String getAdvisoryMessage() {
        return advisoryMessage;
    }

    public void setAdvisoryMessage(String advisoryMessage) {
        this.advisoryMessage = advisoryMessage;
    }
}
