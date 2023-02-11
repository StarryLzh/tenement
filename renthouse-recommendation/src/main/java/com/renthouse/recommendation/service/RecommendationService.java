package com.renthouse.recommendation.service;

import com.renthouse.commons.vo.RenthouseResult;

/**
 * @author Lee
 * @date 01-08-周日-22:54
 */
public interface RecommendationService {
    /**
     * 查询热门推荐商品信息， 查询条件是所在城市
     * @param city 查城市
     * @return 返回数据
     */
    RenthouseResult getRecommendation(String city);
}
