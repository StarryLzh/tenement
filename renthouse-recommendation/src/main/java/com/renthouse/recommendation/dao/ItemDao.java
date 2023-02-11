package com.renthouse.recommendation.dao;

import com.renthouse.commons.pojo.Item;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * @author Lee
 * @date  22:32
 */
public interface ItemDao {
    /**
     *查 询热门推荐商品
     * @param query 查询条件
     * @return  查询返回
     */
    List<Item> selectRecommendation(Query query);
}
