package com.renthouse.commons.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Comment {

    //用户名， 手机号
    private String username;

    //评论内容
    private String comment;

    //评分
    private  int star;

    //商品id 商品主键，是为哪一个商品做的评价。
    private String itemId;
}
