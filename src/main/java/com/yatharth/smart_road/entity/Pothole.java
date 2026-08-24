package com.yatharth.smart_road.entity;

import jakarta.persistence.*;

@Entity
public class Pothole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roadName;

    private Double latitude;

    private Double longitude;

    private String severity;

    private String depth;

    private String reportedAt;

    @Column(columnDefinition = "LONGTEXT")
    private String imageUrl;

    @Column(nullable = false)
    private String status = "ACTIVE"; // ACTIVE | FIXED

    public Pothole() {
    }

    public Pothole(String roadName, Double latitude, Double longitude, String severity, String depth, String reportedAt, String imageUrl) {
        this.roadName = roadName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.severity = severity;
        this.depth = depth;
        this.reportedAt = reportedAt;
        this.imageUrl = imageUrl;
        this.status = "ACTIVE";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRoadName() { return roadName; }
    public void setRoadName(String roadName) { this.roadName = roadName; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getDepth() { return depth; }
    public void setDepth(String depth) { this.depth = depth; }

    public String getReportedAt() { return reportedAt; }
    public void setReportedAt(String reportedAt) { this.reportedAt = reportedAt; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}