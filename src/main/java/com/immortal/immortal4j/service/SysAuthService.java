package com.immortal.immortal4j.service;

import com.immortal.immortal4j.base.BaseService;
import com.immortal.immortal4j.entity.SysMenu;
import com.immortal.immortal4j.entity.SysRoleMenu;
import com.immortal.immortal4j.entity.SysUserMenu;
import com.immortal.immortal4j.entity.SysUserRole;

import java.util.List;
import java.util.Map;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/7/29 14:47
 */
public interface SysAuthService extends BaseService {
    public List<String> queryMenuIdsByUserId(Long userId);

    public void updateUserMenu(List<SysUserMenu> sysUserMenus,Long userId,Long currentUserId);

    public List<SysUserRole> getRolesByUserId(Long userId);

    public void updateUserRole(List<SysUserRole> sysUserRoles,Long userId,Long currentUserId);

    public List<String> queryMenuIdsByRoleId(Long roleId);

    public void updateRoleMenu(List<SysRoleMenu> sysRoleMenus,Long userId,Long currentUserId);

    public List<SysMenu> queryAuthorizeByUserId(Long userId);

    public List<String> queryPermissionByUserId(Long userId);

    public List<String> queryUserMenuName(Long userId);

    public List<String> queryRoleMenuName(Long roleId);

    public List<SysMenu> queryMenusPermission();

    public List<Map<String, Object>> queryUserPermissions(SysUserMenu sysUserMenu);

    public List<Map<String, Object>> queryRolePermissions(SysRoleMenu sysRoleMenu);
}