package com.renthouse.recommendation.controller;

import com.renthouse.commons.vo.RenthouseResult;
import com.renthouse.recommendation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lee
 * @date 01/09/周一 0:04
 */
@RestController
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/recommendation")
    public RenthouseResult getRecommendation(String city){
        return recommendationService.getRecommendation(city);
    }
}
