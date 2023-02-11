package com.renthouse.commons.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 登录日志
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginLog {
    //日志id
    private String id;
    //登录用户
    private String username;
    //登录方式
    private String type;
    //登录时间
    private Data loginTime;
    //登录是否成功
    private Boolean isSuccess;
    //日志消息
    private String message;
}
