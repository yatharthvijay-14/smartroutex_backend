package com.yatharth.smart_road.repository;

import com.yatharth.smart_road.entity.Pothole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PotholeRepository extends JpaRepository<Pothole, Long> {

    List<Pothole> findBySeverity(String severity);
    List<Pothole> findByReportedBy(String reportedBy);
}