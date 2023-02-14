package com.renthouse.detail.dao;

import com.renthouse.commons.pojo.Item;

/**
 * @author Lee
 * @date 02/14/周二 15:53
 */
public interface ItemDao {
    Item findItemById(String id);
}
