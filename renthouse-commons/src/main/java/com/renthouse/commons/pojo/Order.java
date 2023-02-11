package com.renthouse.commons.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 订单类
 */
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Order {
    //订单id
    private String id;
    //用户手机号
    private String username;
    //商品标题
    private String title;
    //房屋类型
    private String houseType;
    //租赁方式-整租\合租
    private String rentType;
    //价格
    private String price;
    //图片
    private String img;
    //评论状态 0-未评论 1-已评论
    private int commentState;
}
