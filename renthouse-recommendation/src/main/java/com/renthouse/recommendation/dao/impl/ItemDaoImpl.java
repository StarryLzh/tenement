package com.renthouse.recommendation.dao.impl;

import com.renthouse.commons.pojo.Item;
import com.renthouse.recommendation.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Lee
 * @date 22:33
 */
@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     *
     * @param query 查询条件
     * @return mongoTemplate.find 查询结果
     */
    @Override
    public List<Item> selectRecommendation(Query query) {
        return mongoTemplate.find(query,Item.class);
    }

}
