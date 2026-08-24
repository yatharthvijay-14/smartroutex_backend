package com.yatharth.smart_road.dto;

import com.yatharth.smart_road.entity.Pothole;
import java.util.List;

public class EvaluatedRouteDTO {

    private String id;
    private String name;
    private String title;
    private List<double[]> coordinates;
    private String distance;
    private String duration;
    private List<Pothole> detectedPotholes;
    private Integer potholeCount;
    private Double riskScore;
    private Double safetyScore;
    private String statusTag;
    private String statusColor;

    public EvaluatedRouteDTO() {}

    public EvaluatedRouteDTO(String id, String name, String title, List<double[]> coordinates, String distance, String duration, List<Pothole> detectedPotholes, Integer potholeCount, Double riskScore, Double safetyScore, String statusTag, String statusColor) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.coordinates = coordinates;
        this.distance = distance;
        this.duration = duration;
        this.detectedPotholes = detectedPotholes;
        this.potholeCount = potholeCount;
        this.riskScore = riskScore;
        this.safetyScore = safetyScore;
        this.statusTag = statusTag;
        this.statusColor = statusColor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Pothole> getDetectedPotholes() {
        return detectedPotholes;
    }

    public void setDetectedPotholes(List<Pothole> detectedPotholes) {
        this.detectedPotholes = detectedPotholes;
    }

    public Integer getPotholeCount() {
        return potholeCount;
    }

    public void setPotholeCount(Integer potholeCount) {
        this.potholeCount = potholeCount;
    }

    public Double getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(Double riskScore) {
        this.riskScore = riskScore;
    }

    public Double getSafetyScore() {
        return safetyScore;
    }

    public void setSafetyScore(Double safetyScore) {
        this.safetyScore = safetyScore;
    }

    public String getStatusTag() {
        return statusTag;
    }

    public void setStatusTag(String statusTag) {
        this.statusTag = statusTag;
    }

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }
}
