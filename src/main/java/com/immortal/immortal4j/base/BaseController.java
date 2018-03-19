package com.immortal.immortal4j.base;

import com.immortal.immortal4j.exception.BizException;
import com.immortal.immortal4j.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/18 0:40
 */
public class BaseController<T extends BaseEntity> {
    @Autowired
    protected BaseService<T> service;

    @GetMapping(value = "/{id}")
    public T get(@PathVariable Long id){
        T t = service.get(id);
        if (t == null){
            throw new NotFoundException("部门不存在");
        }
        return t;
    }

    @DeleteMapping(value = "/{id}")
    public void del(@PathVariable Long id){
        service.del(id);
    }
}
