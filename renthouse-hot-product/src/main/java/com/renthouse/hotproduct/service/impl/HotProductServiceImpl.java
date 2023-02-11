package com.renthouse.hotproduct.service.impl;

import com.renthouse.commons.pojo.Item;
import com.renthouse.commons.vo.RenthouseResult;
import com.renthouse.hotproduct.dao.ItemDao;
import com.renthouse.hotproduct.service.HotProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HotProductServiceImpl implements HotProductService {
    @Autowired
    private ItemDao itemDao;

    @Value("${renthouse.banner.nginx.prefix}")
    private String nginxPrefix;

    @Override
    public RenthouseResult getHotProduct(String city) {
        Query query = new Query();
        query.addCriteria(Criteria.where("city").is(city));
        //排序和分页
        query.with(PageRequest.of(0,4));
        List<Item> items = itemDao.getHotProduct(query);
        //数据不足4
        if (items.size() < 4){
            Query query1 = new Query();
            //ne：不等于
            query1.addCriteria(Criteria.where("city").ne(city));
            query.with(PageRequest.of(0,4));
            List<Item> items1 = itemDao.getHotProduct(query1);
            //把数据凑够
            items.addAll(items1);
        }
        //数据仍然不足，兜底
        if(items.size()<4){
            for (int i = items.size(); i < 4; i++) {
                //自定义的兜底方法
                items.add(fallbackItem());
            }
        }

        //图片路径转化成完整的可访问路径
        items = this.changeImgUrl(items);
        return RenthouseResult.ok(items);
    }

    // 将集合中的每个Item类型对象的图片地址，增加前缀。
    private List<Item> changeImgUrl(List<Item> items){
        for(Item item : items){
            List<String> newImgs = new ArrayList<>();
            for(String img : item.getImgs()){
                newImgs.add(nginxPrefix + img);
            }
            item.setImgs(newImgs);
        }
        return items;
    }

    /**
     * 数据不足的兜底方法
     */
    private Item fallbackItem(){
        Item item = new Item();
        item.setId("5ec1ec6b7f56a946fb7fdffa");
        item.setCity("北京");
        item.setHouseType("150 ㎡");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/01/wKhZjF6_UkuAGCsJABLGy04UWBI573.png",
                        "group1/M00/00/01/wKhZjF6_UlyANqRfAAjIoXS-cuE984.png",
                        "group1/M00/00/01/wKhZjF6_UmmAQsntAAro96E3Lio262.png"
                ));
        item.setPrice(12000L);
        item.setRecommendation(true);
        item.setRecoSort((byte)9);
        item.setRentType("整租");
        item.setSales(100L);
        item.setTitle("北京高档公寓");
        Map<String, String> info = new HashMap<>();
        info.put("years", "2010");
        info.put("type", "3室2厅");
        info.put("level", "10/18层");
        info.put("style", "精装修");
        info.put("orientation", "南北通透");
        item.setInfo(info);
        return item;
    }
}
