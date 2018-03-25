package com.immortal.immortal4j.base;

import com.immortal.immortal4j.base.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/11 1:04
 */
public class BaseService<T extends BaseEntity> {
    @Autowired
    protected  JpaRepository<T,Long> repository;

    /**
     * 新建或更新
     * @param entity 实体类
     * @param userId 当前用户id
     * @return
     */
    @Transactional
    public T update(T entity, Long userId){
        if (entity.getId() == null){
            //新建
            entity.setCreateTime(new Date());
            entity.setCreateBy(userId);
            entity.setEnable(1);
        }
        entity.setUpdateTime(new Date());
        entity.setUpdateBy(userId);

        repository.save(entity);
        return entity;
    }


    public T get(Long id){
        T t = repository.findOne(id);
        return t;
    }

    /**
     * 逻辑删除
     * @param id 主键
     * @param userId 当前用户id
     */
    public void del(Long id, Long userId){
        T t = get(id);
        t.setEnable(0);
        t.setUpdateTime(new Date());
        t.setUpdateBy(userId);
    }
    public void del(T t, Long userId){
        T _t = get(t.getId());
        _t.setEnable(0);
        _t.setUpdateTime(new Date());
        _t.setUpdateBy(userId);
    }

    /**
     * 物理删除
     * @param id
     */
    public void delete(Long id){
        repository.delete(id);
    }

    /**
     * 物理删除
     * @param t
     */
    public void delete(T t){
        repository.delete(t);
    }

    /**
     * 简单分页查询
     * @param pageable
     * @return
     */
    public Page<T> page(Pageable pageable){
        return repository.findAll(pageable);
    }

    /**
     * 简单查询全部
     * @return
     */
    public List<T> list(){
        return  repository.findAll();
    }
}
