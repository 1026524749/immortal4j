package com.immortal.immortal4j.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/11 1:04
 */
public abstract class BaseServiceImpl{
    /**
     * 获取默认的Dao类
     * @return
     */
    protected abstract JpaRepository getDefaultRepository();

    /**
     * 新建或更新
     * @param entity 实体类
     * @param userId 当前用户id
     * @return
     */
    public BaseEntity update(BaseEntity entity, Long userId){
        if (entity.getId() == null){
            setCreateParam(entity,userId,new Date());
        }else{
            setUpdateByParam(entity,userId,new Date());
        }
        return (BaseEntity)getDefaultRepository().save(entity);
    }


    public BaseEntity get(Long id){
        Optional<BaseEntity> t = getDefaultRepository().findById(id);
        return t.orElse(null);

    }

    /**
     * 逻辑删除
     * @param id 主键
     * @param userId 当前用户id
     */
    public void del(Long id, Long userId){
        BaseEntity t = get(id);
        t.setEnable(0);
        setUpdateByParam(t,userId,new Date());
        getDefaultRepository().save(t);
    }

    /**
     * 逻辑删除
     * @param entityList 实体类集合
     * @param userId 当前用户id
     */
    public void delBatch(List entityList, Long userId){
        for(Object entity:entityList){
            BaseEntity t = (BaseEntity) entity;
            t.setEnable(0);
            setUpdateByParam(t,userId,new Date());

        }
        getDefaultRepository().saveAll(entityList);
    }


    /**
     * 物理删除
     * @param id
     */
    public void delete(Long id){
        getDefaultRepository().deleteById(id);
    }

    /**
     * 简单分页查询
     * @param pageable
     * @return
     */
    public Page<BaseEntity> page(Pageable pageable){
        return getDefaultRepository().findAll(pageable);
    }

    /**
     * 简单查询全部
     * @return
     */
    public List<BaseEntity> list(){
        return  getDefaultRepository().findAll();
    }

    protected   void  setCreateParam(BaseEntity entity,Long userId,Date date){
        setUpdateByParam(entity,userId,date);
        entity.setCreateBy(userId);
        entity.setCreateTime(date);
        entity.setEnable(1);
    }
    protected   void  setCreateParamBatch(List entityList,Long userId,Date date){
        for(Object entity:entityList){
            BaseEntity t = (BaseEntity) entity;
            setUpdateByParam(t,userId,date);
            t.setCreateBy(userId);
            t.setCreateTime(date);
            t.setEnable(1);
        }

    }

    protected  void setUpdateByParam(BaseEntity entity,Long userId,Date date){
        entity.setUpdateBy(userId);
        entity.setUpdateTime(date);
    }
    protected  void setUpdateByParamBatch(List entityList,Long userId,Date date){
        for(Object entity:entityList){
            BaseEntity t = (BaseEntity) entity;
            t.setUpdateBy(userId);
            t.setUpdateTime(date);
        }
    }

}
