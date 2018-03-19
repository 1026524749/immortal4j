package com.immortal.immortal4j.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/18 19:38
 */
public class BizException extends BaseException {
    @Override
    public Object handler() {
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("msg",this.getMessage());
        result.put("timestamp",System.currentTimeMillis());
        return result;
    }

    public BizException() {
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
