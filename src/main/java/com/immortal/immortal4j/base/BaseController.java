package com.immortal.immortal4j.base;

import com.immortal.immortal4j.support.PageParam;
import com.immortal.immortal4j.support.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/18 0:40
 */
public class BaseController<T extends BaseEntity> {
    @Autowired
    protected BaseService<T> service;

    /**
     * 简单查询
     * @param param
     * @return
     */
    protected PageResult page(PageParam param){
        Pageable pageable = new PageRequest(param.getPage(),param.getPageSize());
        Page<T> page = service.page(pageable);
        PageResult result = new PageResult();
        result.setPage(param.getPage());
        result.setPageSize(param.getPageSize());
        result.setPages(page.getTotalPages());
        result.setTotals(page.getTotalElements());
        result.setData(page.getContent());
        return result;
    }

    /**
     * 简单查询全部
     * @return
     */
    protected List<T> list(){
        return service.list();
    }

    /**
     * 内部逻辑删除
     * @param t
     */
    protected final void del(T t){
        service.del(t.getId(),getCurrentUser());
    }

    /**
     * 逻辑删除
     * @param id
     */
    protected final void del(Long id){
        service.del(id,getCurrentUser());
    }

    /**
     * 内部更新
     * @param t
     * @return
     */
    protected final  T update(T t){
        return service.update(t,getCurrentUser());
    }

    /**
     * 获取当前用户id
     * @return
     */
    protected Long getCurrentUser(){
        //return WebUtil.getCurrentUser();
        return  1L;
    }
}
