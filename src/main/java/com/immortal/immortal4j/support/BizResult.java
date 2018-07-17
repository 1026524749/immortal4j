package com.immortal.immortal4j.support;

import com.immortal.immortal4j.exception.BizException;

import java.sql.Timestamp;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/7/17 22:25
 */
public class BizResult {
    private int code =HttpCode.EXCEPTION.getValue();
    private String msg;
    private long timestamp;
    private Object data;

    public BizResult(HttpCode httpCode){
        code = httpCode.getValue();
        msg = httpCode.getReasonPhrase();
        timestamp = System.currentTimeMillis();
    }
    public BizResult(Object data){
        this.data = data;
        code = HttpCode.SUCCESS.getValue();
        msg = HttpCode.SUCCESS.getReasonPhrase();
        timestamp = System.currentTimeMillis();
    }
    public BizResult(Object data,HttpCode httpCode){
        this.data = data;
        code = httpCode.getValue();
        msg = httpCode.getReasonPhrase();
        timestamp = System.currentTimeMillis();
    }
    private BizResult(){
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
