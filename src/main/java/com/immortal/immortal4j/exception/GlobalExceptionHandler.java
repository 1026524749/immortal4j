package com.immortal.immortal4j.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/18 19:42
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Object> handlerBaseException(final BaseException ex, final WebRequest req){
        if (ex instanceof BizException){
            Object result = ((BizException)ex).handler();
            return new ResponseEntity<Object>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }else if (ex instanceof NotFoundException){
            return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handlerRuntimeException(final RuntimeException ex, final WebRequest req){
            ex.printStackTrace();
            Map<String,Object> result = new HashMap<String,Object>();
            result.put("msg","系统出现未知异常");
            result.put("timestamp",System.currentTimeMillis());
            return new ResponseEntity<Object>(result, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
