package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/9 17:09
 */
@Entity
public class SysMenu extends BaseEntity {
    private String menuName;
    private Boolean menuType;
    private Long parentId;

    @Column(name = "iconcls_")
    private String iconcls;

    @Column(name = "request_")
    private String request;

    @Column(name = "expand_")
    private Boolean expand;

    private Integer sortNo;
    private String isShow;

    @Column(name = "permission_")
    private String permission;

    @Transient
    private String parentName;
    @Transient
    private Integer leaf = 1;
    @Transient
    private String typeName;
    @Transient
    private String permissionText;
    @Transient
    private List<SysMenu> menuBeans;
}
