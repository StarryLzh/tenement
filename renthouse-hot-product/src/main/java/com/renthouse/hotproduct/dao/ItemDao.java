package com.renthouse.hotproduct.dao;

import com.renthouse.commons.pojo.Item;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface ItemDao {

    List<Item> getHotProduct(Query query);
}
