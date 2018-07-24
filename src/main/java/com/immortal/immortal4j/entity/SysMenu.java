package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/9 17:09
 */
@Entity
@Where(clause = " enable_=1")
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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Boolean getMenuType() {
        return menuType;
    }

    public void setMenuType(Boolean menuType) {
        this.menuType = menuType;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getIconcls() {
        return iconcls;
    }

    public void setIconcls(String iconcls) {
        this.iconcls = iconcls;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Boolean getExpand() {
        return expand;
    }

    public void setExpand(Boolean expand) {
        this.expand = expand;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getPermissionText() {
        return permissionText;
    }

    public void setPermissionText(String permissionText) {
        this.permissionText = permissionText;
    }

    public List<SysMenu> getMenuBeans() {
        return menuBeans;
    }

    public void setMenuBeans(List<SysMenu> menuBeans) {
        this.menuBeans = menuBeans;
    }
}
