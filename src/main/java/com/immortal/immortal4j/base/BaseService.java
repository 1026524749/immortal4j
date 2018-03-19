package com.immortal.immortal4j.base;

import com.immortal.immortal4j.base.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/11 1:04
 */
public class BaseService<T extends BaseEntity> {
    @Autowired
    protected  JpaRepository<T,Long> repository;

    @Transactional
    public T update(T entity){
        if (entity.getId() == null){
            //新建
            entity.setCreateTime(new Date());
            entity.setCreateBy(1L);
            entity.setEnable(1);
        }
        entity.setUpdateTime(new Date());
        entity.setUpdateBy(2L);

        repository.save(entity);
        return entity;
    }

    public T get(Long id){
        T t = repository.findOne(id);
        if (t == null || t.getId() == null){
            return null;
        }
        return t;
    }

    /**
     * 逻辑删除
     * @param id
     */
    public void del(Long id){
        T t = get(id);
        t.setEnable(0);
        t.setUpdateTime(new Date());
        t.setUpdateBy(2L);
    }
    public void delete(Long id){
        repository.delete(id);
    }
}
