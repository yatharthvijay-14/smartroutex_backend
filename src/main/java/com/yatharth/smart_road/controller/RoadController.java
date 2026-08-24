package com.yatharth.smart_road.controller;

import com.yatharth.smart_road.dto.MultiRouteEvaluationRequest;
import com.yatharth.smart_road.dto.MultiRouteEvaluationResponse;
import com.yatharth.smart_road.dto.RoutePlanRequest;
import com.yatharth.smart_road.dto.RoutePlanResponse;
import com.yatharth.smart_road.dto.RouteRecommendationResponse;
import com.yatharth.smart_road.entity.Road;
import com.yatharth.smart_road.service.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roads")
@CrossOrigin(origins = "*")
public class RoadController {

    @Autowired
    private RoadService service;

    @GetMapping
    public List<Road> getAllRoads() {
        return service.getAllRoads();
    }

    @GetMapping("/status/{status}")
    public List<Road> getRoadsByStatus(@PathVariable String status) {
        return service.getRoadsByStatus(status);
    }

    @GetMapping("/best")
    public List<Road> getBestRoads() {
        return service.getBestRoads();
    }

    @GetMapping("/high-risk")
    public List<Road> getHighRiskRoads() {
        return service.getRoadsByStatus("HIGH");
    }

    @GetMapping("/good")
    public List<Road> getGoodRoads() {
        return service.getSafeRoads();
    }

    @GetMapping("/recommended")
    public List<Road> getRecommendedRoads() {
        return service.getRecommendedRoads();
    }

    @GetMapping("/ai-recommendations")
    public RouteRecommendationResponse getAIRouteRecommendations() {
        return service.getAIRouteRecommendation();
    }

    @PostMapping("/plan-route")
    public RoutePlanResponse planMapRoute(@RequestBody RoutePlanRequest request) {
        return service.planMapRoute(request);
    }

    // Phase 5 Spring Boot REST Endpoint for Multi-Route Evaluation
    @PostMapping("/evaluate-multi-routes")
    public MultiRouteEvaluationResponse evaluateMultiRoutes(@RequestBody MultiRouteEvaluationRequest request) {
        return service.evaluateMultiRoutes(request);
    }
}