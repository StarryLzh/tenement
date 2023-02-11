package com.renthouse.banner.controller;

import com.renthouse.banner.serivce.BannerService;
import com.renthouse.commons.vo.RenthouseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BannerController {

    @Autowired
    private BannerService bannerService;

    /**
     * 查询轮播图
     * @return
     */

    @GetMapping("/banner")
    public RenthouseResult banner(){

        return bannerService.getBanners();
    }
}
