package com.yatharth.smart_road.service;

import com.yatharth.smart_road.entity.Pothole;
import com.yatharth.smart_road.repository.PotholeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PotholeService {

    @Autowired
    private PotholeRepository repository;

    @Autowired
    private RoadService roadService;

    @Autowired
    private EmailService emailService;

    @PostConstruct
    public void seedInitialPotholesIfEmpty() {
        String realImg1 = "/potholes/pothole1.png";
        String realImg2 = "/potholes/pothole2.png";
        String realImg3 = "/potholes/pothole3.png";

        if (repository.count() == 0) {
            repository.save(new Pothole("Direct City Corridor (Pothole Zone A)", 25.1750, 75.8410, "HIGH", "15 cm", "10 mins ago", realImg1, "system"));
            repository.save(new Pothole("Aerodrome Circle Road (Pothole Zone B)", 25.1650, 75.8450, "HIGH", "12 cm", "25 mins ago", realImg2, "system"));
            repository.save(new Pothole("Rajeev Gandhi Nagar", 25.1600, 75.8700, "MEDIUM", "8 cm", "1 hour ago", realImg3, "system"));
            repository.save(new Pothole("Vigyan Nagar Flyover", 25.1810, 75.8390, "HIGH", "14 cm", "2 hours ago", realImg1, "system"));
            repository.save(new Pothole("Nayapura Heritage Road", 25.1820, 75.8400, "LOW", "5 cm", "4 hours ago", realImg2, "system"));
        } else {
            // Auto-clean legacy mask/unsplash URLs from database
            List<Pothole> existing = repository.findAll();
            int idx = 0;
            String[] fallbacks = {realImg1, realImg2, realImg3};
            for (Pothole p : existing) {
                if (p.getImageUrl() != null && (p.getImageUrl().contains("unsplash") || p.getImageUrl().contains("1515162816999") || p.getImageUrl().contains("1584467735815"))) {
                    p.setImageUrl(fallbacks[idx % fallbacks.length]);
                    repository.save(p);
                    idx++;
                }
            }
        }
    }

    public List<Pothole> getAllPotholes() {
        return repository.findAll();
    }

    public List<Pothole> getPotholesByReportedBy(String username) {
        if (username == null || username.trim().isEmpty()) {
            return List.of();
        }
        return repository.findByReportedBy(username);
    }

    public Pothole addPothole(Pothole pothole) {
        if (pothole.getReportedAt() == null) {
            pothole.setReportedAt("Just now");
        }
        if (pothole.getDepth() == null) {
            pothole.setDepth("10 cm");
        }
        if (pothole.getStatus() == null) {
            pothole.setStatus("ACTIVE");
        }
        Pothole saved = repository.save(pothole);
        if (pothole.getRoadName() != null && pothole.getSeverity() != null) {
            roadService.updateRoadRiskOnPotholeReport(pothole.getRoadName(), pothole.getSeverity());
        }

        // Trigger email notification
        try {
            emailService.sendPotholeNotification(saved);
        } catch (Exception e) {
            System.err.println("Failed to send pothole email alert: " + e.getMessage());
        }

        return saved;
    }

    public Optional<Pothole> markAsFixed(Long id) {
        return repository.findById(id).map(p -> {
            p.setStatus("FIXED");
            return repository.save(p);
        });
    }

    public boolean deletePothole(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Pothole> removeImage(Long id) {
        return repository.findById(id).map(p -> {
            p.setImageUrl(null);
            return repository.save(p);
        });
    }

    public List<Pothole> getHighSeverityPotholes() {
        return repository.findBySeverity("HIGH");
    }
}