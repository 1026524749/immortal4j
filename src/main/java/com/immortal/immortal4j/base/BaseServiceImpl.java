package com.immortal.immortal4j.base;

import com.immortal.immortal4j.base.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

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
            //新建
            entity.setCreateTime(new Date());
            entity.setCreateBy(userId);
            entity.setEnable(1);
        }
        entity.setUpdateTime(new Date());
        entity.setUpdateBy(userId);
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
        t.setUpdateTime(new Date());
        t.setUpdateBy(userId);
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

}
