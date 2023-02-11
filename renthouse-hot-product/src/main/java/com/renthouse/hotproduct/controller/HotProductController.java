package com.renthouse.hotproduct.controller;

import com.renthouse.commons.vo.RenthouseResult;
import com.renthouse.hotproduct.service.HotProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotProductController {
    @Autowired
    private HotProductService hotProductService;

    @GetMapping("/hotProduct")
    public RenthouseResult getHotProduct(String city){
        RenthouseResult hotProduct = hotProductService.getHotProduct(city);
        return hotProduct;
    }
}
