package com.yatharth.smart_road.repository;

import com.yatharth.smart_road.entity.Road;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoadRepository extends JpaRepository<Road, Long> {

    List<Road> findByStatus(String status);

    List<Road> findByOrderByRatingDesc();
}