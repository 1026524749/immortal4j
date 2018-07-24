package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/9 16:01
 */
@Entity
@Where(clause = " enable_=1")
public class SysRole extends BaseEntity {
    private String roleName;
    private Long deptId;
    private Integer roleType;

    @Transient
    private String deptName;
    @Transient
    private String permission;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
