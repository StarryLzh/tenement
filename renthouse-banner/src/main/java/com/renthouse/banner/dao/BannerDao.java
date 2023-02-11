package com.renthouse.banner.dao;


import com.renthouse.commons.pojo.Banner;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;


public interface BannerDao {
    List<Banner> selectBanners(Query query);

}
