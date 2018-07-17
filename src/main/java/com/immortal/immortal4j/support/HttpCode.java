package com.immortal.immortal4j.support;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/7/17 21:51
 */
public enum HttpCode {
    //常用状态码
    SUCCESS(0,"请求成功"),
    PARAM_ERROR(1,"参数错误"),
    NON_AUTH(401, "未授权"),
    NOT_FOUND(404, "资源不存在"),
    EXCEPTION(9999,"未知异常");

    //业务状态码

    private final int value;
    private final String reasonPhrase;
    private HttpCode(int value,String reasonPhrase){
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }
    public String getReasonPhrase(){
        return reasonPhrase;
    }
    public int getValue(){
        return value;
    }
}
