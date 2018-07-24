package com.immortal.immortal4j.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/7/23 0:43
 */
public interface BaseService{
    /**
     * 新建或更新
     * @param entity
     * @param userId  当前用户id
     * @return
     */
    public BaseEntity update(BaseEntity entity, Long userId);

    /**
     * 获取数据
     * @param id
     * @return
     */
    public BaseEntity get(Long id);

    /**
     * 逻辑删除
     * @param id
     * @param userId  当前用户
     */
    public void del(Long id, Long userId);

    /**
     * 物理删除
     * @param id
     */
    public void delete(Long id);

    /**
     * 简单分页
     * @param pageable
     * @return
     */
    public Page<BaseEntity> page(Pageable pageable);

    /**
     * 获取全部数据
     * @return
     */
    public List<BaseEntity> list();
}
