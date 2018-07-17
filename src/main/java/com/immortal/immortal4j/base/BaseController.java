package com.immortal.immortal4j.base;

import com.immortal.immortal4j.query.PageParam;
import com.immortal.immortal4j.query.PageResult;
import com.immortal.immortal4j.support.BizResult;
import com.immortal.immortal4j.support.HttpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/18 0:40
 */
public abstract class BaseController{

    /**
     * 获取当前用户id
     * @return
     */
    protected Long getCurrentUser(){
        //return WebUtil.getCurrentUser();
        return  1L;
    }
    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    protected String getRequestURI() {
        return getRequest().getRequestURI();
    }

    /**
     * 不带数据的自定义返回结果
     * @return
     */
    protected Object setSuccess(){
        return new BizResult(HttpCode.SUCCESS);
    }

    /**
     * 带参数的自定义返回结果
     * @param data
     * @return
     */
    protected Object setSuccess(Object data){
        return new BizResult(data);
    }
}
