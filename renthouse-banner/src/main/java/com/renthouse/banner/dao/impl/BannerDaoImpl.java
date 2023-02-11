package com.renthouse.banner.dao.impl;

import com.renthouse.banner.dao.BannerDao;
import com.renthouse.commons.pojo.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BannerDaoImpl implements BannerDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Banner> selectBanners(Query query) {
        /**
         * 1-查询条件，2-返回的Class类型
         */
        List<Banner> banners = mongoTemplate.find(query,Banner.class);
        return banners;
    }
}
