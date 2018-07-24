package com.immortal.immortal4j.support;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/7/17 21:51
 */
public enum HttpCode {
    //常用状态码
    SUCCESS(0,"请求成功"),
    PARAM_ERROR(1,"参数错误"),
    ClASS_NOT_FOUND(20,"ClASS_NOT_FOUND异常"),
    NON_AUTH(401, "未授权"),
    NOT_FOUND(404, "资源不存在"),
    EXCEPTION(9999,"未知异常"),

    //类型转换异常
    TYPE_PARSE_STRING(30, "STRING类型转换异常"),
    TYPE_PARSE_BOOLEAN(31, "BOOLEAN类型转换异常"),
    TYPE_PARSE_INTEGER(32, "INTEGER类型转换异常"),
    TYPE_PARSE_DOUBLE(33, "DOUBLE类型转换异常"),
    TYPE_PARSE_FLOAT(34, "FLOAT类型转换异常"),
    TYPE_PARSE_BIGDECIMAL(35, "BIGDECIMAL类型转换异常"),
    TYPE_PARSE_DATE(36, "DATE类型转换异常"),
    TYPE_PARSE_TIME(37, "TIME类型转换异常"),
    TYPE_PARSE_TIMESTAMP(38, "TIMESTAMP类型转换异常"),
    TYPE_PARSE_OTHER(39, "其他类型转换异常");
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
