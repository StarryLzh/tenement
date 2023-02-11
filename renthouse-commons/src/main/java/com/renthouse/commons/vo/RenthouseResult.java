package com.renthouse.commons.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 返回前端json数据
 * 进行封装
 */
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class RenthouseResult {
    //返回状态 200-成功 500-失败
    private int status;
    //返回结果
    private Object results;
    //提示消息
    private String msg;
    //返回的数据
    private Object data;
    //分页放回结果，是否还有更多的数据
    private boolean hasMore;
    //预定时间
    private long time;

    //四个静态 构造方法
    public static RenthouseResult ok(){
        RenthouseResult renthouseResult = new RenthouseResult();
        renthouseResult.setStatus(200);
        return renthouseResult;
    }

    public static RenthouseResult ok(Object data){
        RenthouseResult renthouseResult = new RenthouseResult();
        renthouseResult.setStatus(200);
        renthouseResult.setData(data);
        return renthouseResult;
    }

    public static RenthouseResult error(){
        RenthouseResult renthouseResult = new RenthouseResult();
        renthouseResult.setStatus(500);
        return renthouseResult;
    }

    public static RenthouseResult error(String msg){
        RenthouseResult renthouseResult = new RenthouseResult();
        renthouseResult.setStatus(500);
        renthouseResult.setMsg(msg);
        return renthouseResult;
    }
}
