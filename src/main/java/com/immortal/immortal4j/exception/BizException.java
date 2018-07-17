package com.immortal.immortal4j.exception;

import com.immortal.immortal4j.support.BizResult;
import com.immortal.immortal4j.support.HttpCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/18 19:38
 */
public class BizException extends BaseException {

    private HttpCode httpCode;
    @Override
    public BizResult handler() {

        return new BizResult(httpCode);
    }

    public BizException(HttpCode code) {
        this.httpCode = code;
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
