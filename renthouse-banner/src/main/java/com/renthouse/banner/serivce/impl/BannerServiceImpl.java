package com.renthouse.banner.serivce.impl;

import com.renthouse.banner.dao.BannerDao;
import com.renthouse.banner.serivce.BannerService;
import com.renthouse.commons.pojo.Banner;
import com.renthouse.commons.vo.RenthouseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;

    //引入commons模块配置文件配置的前缀变量
    @Value("${renthouse.banner.nginx.prefix}")
    private String nginxPrefix;


    @Override
    public RenthouseResult getBanners() {
        RenthouseResult renthouseResult = new RenthouseResult();

        try {
            Query query = new Query();
            query.with(PageRequest.of(0,4));
            List<Banner> banners = bannerDao.selectBanners(query);
            renthouseResult.setStatus(200);

            //遍历查询结果,拿到Banner的url，ip:port/group
            ArrayList<Object> imageResults = new ArrayList<>();
            for (Banner banner : banners) {
                //加前缀
                imageResults.add(nginxPrefix+banner.getUrl());
            }
            renthouseResult.setResults(imageResults);

        } catch (Exception e) {
            e.printStackTrace();
            renthouseResult.setStatus(500);
            renthouseResult.setMsg("轮播图查询失败");
        }
        return renthouseResult;
    }
}
