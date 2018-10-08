package com.immortal.immortal4j.exception;

import com.alibaba.fastjson.JSON;
import com.immortal.immortal4j.support.BizResult;
import com.immortal.immortal4j.support.HttpCode;
import com.immortal.immortal4j.utils.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import sun.rmi.runtime.Log;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/18 19:42
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Object> handlerBaseException(final BaseException ex, final WebRequest req){
        if (ex instanceof BizException){
            BizResult result = ((BizException)ex).handler();
            //打印业务异常日志信息
            String param = JSON.toJSONString(req.getParameterMap());
            logger.warn("[timestamp:{}][code:{}][param:{}]",result.getTimestamp(),result.getCode(),param);
            return new ResponseEntity<Object>(result, HttpStatus.OK);
        }

        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handlerRuntimeException(final RuntimeException ex, final WebRequest req){
        BizResult result = new BizResult(HttpCode.EXCEPTION);
        String param = JSON.toJSONString(req.getParameterMap());
        logger.warn("[Exception]-[timestamp:{}][param:{}]",result.getTimestamp(),param);
        ex.printStackTrace();
        return new ResponseEntity<Object>(result, HttpStatus.OK);

    }
}
