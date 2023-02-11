package com.renthouse.recommendation.service.impl;

import com.renthouse.commons.pojo.Item;
import com.renthouse.commons.vo.RenthouseResult;
import com.renthouse.recommendation.dao.ItemDao;
import com.renthouse.recommendation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @author Lee
 * @date 01/08/周日 22:57
 */
@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private ItemDao itemDao;
    /**
     * 前缀
     */
    @Value("${livegoods.banner.nginx.prefix}")
    private String nginxPrefix;

    @Override
    public RenthouseResult getRecommendation(String city) {
        //查询条件
        Query query = new Query();
        Criteria criteria = new Criteria();
        // 查询条件， 城市 = 参数值 and 是否推荐 = true
        criteria.andOperator(Criteria.where("city").is(city),
                                Criteria.where("recommendation").is(true));
        query.addCriteria(criteria);
        //分页
        query.with(PageRequest.of(0,4));

        List<Item> items = itemDao.selectRecommendation(query);

        // 判断查询结果数量是否达标。
        if (items.size()< 4 ){
            // 查询的热门推荐商品数量少于4。 从其他城市的推荐商品中查询
            Query query1 = new Query();
            Criteria criteria1 = new Criteria();
            criteria1.andOperator(Criteria.where("city").ne(city),
                        Criteria.where("recommendation").is(true));
            query1.addCriteria(criteria1);
            query1.with(
                    PageRequest.of(0,4 - items.size(), Sort.by(Sort.Direction.DESC,"recoSort"))
            );
            List<Item> items1 = itemDao.selectRecommendation(query1);

            //把两个查询结果合在一起
            items.addAll(items1);
        }
        //所有数据查出来 还是小于4
        if(items.size() < 4){
            // 所有城市的热门推荐数据，总量少于4条。使用托底数据补足。
            for(int i = items.size(); i < 4; i++){
                items.add(fallbackItem());
            }
        }

        // 把图片URL地址，转换成完整路径。
        items = this.changeImgs(items);

        // 返回结果
        return RenthouseResult.ok(items);
    }

    // 图片地址处理方法，相对路径转换为绝对路径。
    private List<Item> changeImgs(List<Item> items){
        for(Item item : items){
            List<String> newImgs = new ArrayList<>();
            for(String img : item.getImgs()){
                newImgs.add(nginxPrefix + img);
            }
            item.setImgs(newImgs);
        }
        return items;
    }

    // 创建托底数据
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
                )
        );
        item.setPrice(12000L);
        item.setRecommendation(true);
        item.setRecoSort((byte)9);
        item.setRentType("整租");
        item.setSales(100L);
        item.setTitle ("北京高档公寓");
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
