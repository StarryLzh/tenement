package com.renthouse.commons.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 轮播图类
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Banner {
    private String id;

    private String url;

    private Date createTime;
}
