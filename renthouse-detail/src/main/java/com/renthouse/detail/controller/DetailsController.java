package com.renthouse.detail.controller;

import com.renthouse.commons.pojo.Item;
import com.renthouse.detail.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lee
 * @date 02/14/周二 16:03
 */
@RestController
public class DetailsController {
    @Autowired
    private DetailService detailService;

    /**
     * 根据商品id查询商品详情
     * @param id 主键
     * @return 铲鲟结果
     */
    @GetMapping("/details")
    public Item findDetails(String id){
        return detailService.getDetails(id);
    }
}
