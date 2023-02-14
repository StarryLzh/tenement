package com.renthouse.detail.service.impl;

import com.renthouse.commons.pojo.Item;
import com.renthouse.detail.dao.ItemDao;
import com.renthouse.detail.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lee
 * @date 02/14/周二 15:55
 */
@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    private ItemDao itemDao;
    @Value("${renthouse.banner.nginx.prefix}")
    private String nginxPrefix;
    /**
     * 主键查询商品。
     * 需要将商品中的图片地址，从相对路径修改为绝对路径。
     * @param id 主键
     * @return 返回item
     */
    @Override
    public Item getDetails(String id) {
        //主键查询
        Item item = itemDao.findItemById(id);
        // 把图片的相对路径修改成绝对路径。
        List<String > newImgs = new ArrayList<>();
        for (String img : item.getImgs()) {
            newImgs.add(nginxPrefix + img);
        }
        item.setImgs(newImgs);
        return item;
    }
}
