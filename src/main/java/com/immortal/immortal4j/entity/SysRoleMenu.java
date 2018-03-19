package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/9 15:59
 */
@Entity
public class SysRoleMenu extends BaseEntity {
    private Long roleId;
    private Long menuId;
    @Column(name = "permission_")
    private String permission;
}
