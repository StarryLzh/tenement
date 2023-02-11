package com.renthouse.commons.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class ValidateCode {
    //手机号
    private String phone;
    //验证码
    private String validateCode;
}
