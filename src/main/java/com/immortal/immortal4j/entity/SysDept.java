package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/10 20:54
 */
@Entity
public class SysDept extends BaseEntity {
    private String deptName;
    private Long parentId;
    private Integer sortNo;
    private Integer unitId;
    @Column(name = "leaf_")
    private Integer leaf;
    @Transient
    private String parentName;
}
