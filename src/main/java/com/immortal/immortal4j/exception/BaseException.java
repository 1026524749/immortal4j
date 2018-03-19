package com.immortal.immortal4j.exception;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/18 0:51
 */
public abstract class BaseException extends RuntimeException {

    /**
     * 用于定义异常返回信息
     * @return
     */
    public abstract Object handler();

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
