package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/10 20:54
 */
@Entity
@Where(clause = " enable_=1")
public class SysDept extends BaseEntity {
    private String deptName;
    private Long parentId;
    private Integer sortNo;
    private Integer unitId;
    @Column(name = "leaf_")
    private Integer leaf;
    @Transient
    private String parentName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
