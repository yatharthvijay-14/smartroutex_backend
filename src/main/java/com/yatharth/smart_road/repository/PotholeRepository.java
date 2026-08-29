package com.yatharth.smart_road.repository;

import com.yatharth.smart_road.entity.Pothole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PotholeRepository extends JpaRepository<Pothole, Long> {

    List<Pothole> findBySeverity(String severity);
    List<Pothole> findByReportedBy(String reportedBy);
}