package com.immortal.immortal4j.support;

import java.io.Serializable;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/12 23:15
 */
public class Token implements Serializable{
    private String value;
    private Long time;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getTime() {
        return time;
    }
}
