package com.yatharth.smart_road.dto;

import java.util.List;

public class MultiRouteEvaluationResponse {

    private List<EvaluatedRouteDTO> evaluatedRoutes;
    private EvaluatedRouteDTO safestRoute;
    private String safestRouteId;
    private String overallRecommendationAdvisory;

    public MultiRouteEvaluationResponse() {}

    public MultiRouteEvaluationResponse(List<EvaluatedRouteDTO> evaluatedRoutes, EvaluatedRouteDTO safestRoute, String safestRouteId, String overallRecommendationAdvisory) {
        this.evaluatedRoutes = evaluatedRoutes;
        this.safestRoute = safestRoute;
        this.safestRouteId = safestRouteId;
        this.overallRecommendationAdvisory = overallRecommendationAdvisory;
    }

    public List<EvaluatedRouteDTO> getEvaluatedRoutes() {
        return evaluatedRoutes;
    }

    public void setEvaluatedRoutes(List<EvaluatedRouteDTO> evaluatedRoutes) {
        this.evaluatedRoutes = evaluatedRoutes;
    }

    public EvaluatedRouteDTO getSafestRoute() {
        return safestRoute;
    }

    public void setSafestRoute(EvaluatedRouteDTO safestRoute) {
        this.safestRoute = safestRoute;
    }

    public String getSafestRouteId() {
        return safestRouteId;
    }

    public void setSafestRouteId(String safestRouteId) {
        this.safestRouteId = safestRouteId;
    }

    public String getOverallRecommendationAdvisory() {
        return overallRecommendationAdvisory;
    }

    public void setOverallRecommendationAdvisory(String overallRecommendationAdvisory) {
        this.overallRecommendationAdvisory = overallRecommendationAdvisory;
    }
}
