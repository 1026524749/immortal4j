package com.immortal.immortal4j.exception;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/18 23:32
 */
public class NotFoundException extends BaseException {
    @Override
    public Object handler() {
        return null;
    }

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
