package com.immortal.immortal4j.dao;

import com.immortal.immortal4j.entity.SysDic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/11 0:08
 */
public interface SysDicRepository extends JpaRepository<SysDic, Long>{
    /**
     * 按类型查询字段
     * @param type
     * @return
     */
    public List<SysDic> findByType(String type);

}
