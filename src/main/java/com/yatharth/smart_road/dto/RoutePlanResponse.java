package com.yatharth.smart_road.dto;

import com.yatharth.smart_road.entity.Pothole;
import java.util.List;

public class RoutePlanResponse {

    private List<double[]> directPath;
    private List<double[]> safestPath;
    private List<Pothole> nearbyPotholes;
    private int potholeCountOnDirectRoute;
    private int potholeCountOnSafestRoute;
    private double directSafetyScore;
    private double safestSafetyScore;
    private String recommendationAdvisory;
    private String directDistance;
    private String directTime;
    private String safestDistance;
    private String safestTime;

    public RoutePlanResponse() {
    }

    public List<double[]> getDirectPath() {
        return directPath;
    }

    public void setDirectPath(List<double[]> directPath) {
        this.directPath = directPath;
    }

    public List<double[]> getSafestPath() {
        return safestPath;
    }

    public void setSafestPath(List<double[]> safestPath) {
        this.safestPath = safestPath;
    }

    public List<Pothole> getNearbyPotholes() {
        return nearbyPotholes;
    }

    public void setNearbyPotholes(List<Pothole> nearbyPotholes) {
        this.nearbyPotholes = nearbyPotholes;
    }

    public int getPotholeCountOnDirectRoute() {
        return potholeCountOnDirectRoute;
    }

    public void setPotholeCountOnDirectRoute(int potholeCountOnDirectRoute) {
        this.potholeCountOnDirectRoute = potholeCountOnDirectRoute;
    }

    public int getPotholeCountOnSafestRoute() {
        return potholeCountOnSafestRoute;
    }

    public void setPotholeCountOnSafestRoute(int potholeCountOnSafestRoute) {
        this.potholeCountOnSafestRoute = potholeCountOnSafestRoute;
    }

    public double getDirectSafetyScore() {
        return directSafetyScore;
    }

    public void setDirectSafetyScore(double directSafetyScore) {
        this.directSafetyScore = directSafetyScore;
    }

    public double getSafestSafetyScore() {
        return safestSafetyScore;
    }

    public void setSafestSafetyScore(double safestSafetyScore) {
        this.safestSafetyScore = safestSafetyScore;
    }

    public String getRecommendationAdvisory() {
        return recommendationAdvisory;
    }

    public void setRecommendationAdvisory(String recommendationAdvisory) {
        this.recommendationAdvisory = recommendationAdvisory;
    }

    public String getDirectDistance() {
        return directDistance;
    }

    public void setDirectDistance(String directDistance) {
        this.directDistance = directDistance;
    }

    public String getDirectTime() {
        return directTime;
    }

    public void setDirectTime(String directTime) {
        this.directTime = directTime;
    }

    public String getSafestDistance() {
        return safestDistance;
    }

    public void setSafestDistance(String safestDistance) {
        this.safestDistance = safestDistance;
    }

    public String getSafestTime() {
        return safestTime;
    }

    public void setSafestTime(String safestTime) {
        this.safestTime = safestTime;
    }
}
