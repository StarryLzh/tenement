package com.renthouse.detail.dao.impl;

import com.renthouse.commons.pojo.Item;
import com.renthouse.detail.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Lee
 * @date 02/14/周二 15:54
 */
@Repository
public class ItemDaoImpl implements ItemDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 主键查询商品
     * @param id 主键
     * @return 返回查询结果
     */
    @Override
    public Item findItemById(String id) {
        return mongoTemplate.findById(id,Item.class);
    }
}
