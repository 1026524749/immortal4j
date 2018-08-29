package com.immortal.immortal4j.service.impl;

import com.immortal.immortal4j.base.BaseServiceImpl;
import com.immortal.immortal4j.dao.SysRoleMenuRepository;
import com.immortal.immortal4j.dao.SysUserMenuRepository;
import com.immortal.immortal4j.dao.SysUserRepository;
import com.immortal.immortal4j.dao.SysUserRoleRepository;
import com.immortal.immortal4j.entity.*;
import com.immortal.immortal4j.service.SysAuthService;
import com.immortal.immortal4j.service.SysDicService;
import com.immortal.immortal4j.service.SysMenuService;
import com.immortal.immortal4j.service.SysUserService;
import com.immortal.immortal4j.utils.InstanceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/7/29 14:56
 */
@Service
public class SysAuthServiceImpl extends BaseServiceImpl implements SysAuthService {
    @Autowired
    private SysRoleMenuRepository roleMenuRepository;
    @Autowired
    private SysUserRoleRepository userRoleRepository;
    @Autowired
    private SysUserMenuRepository userMenuRepository;
    @Autowired
    private SysUserRepository userRepository;

    @Autowired
    private SysMenuService menuService;

    @Autowired
    private SysDicService dicService;

    @Override
    protected JpaRepository getDefaultRepository() {
        return roleMenuRepository;
    }

    @Override
    public List<String> queryMenuIdsByUserId(Long userId) {

        List<SysUserMenu> list = userMenuRepository.findByUserId(userId);
        //通过留的方式获取menuid
        List<String> resultList = list.stream().map(i -> i.getMenuId().toString()).collect(Collectors.toList());
        return resultList;
    }

    @Override
    public void updateUserMenu(List<SysUserMenu> sysUserMenus, Long userId,Long currentUserId) {
        Date currentDate = new Date();
        //删除原来的用户菜单
        userMenuRepository.deleteUserMenuByUserId(userId,currentUserId,currentDate);
        //保存新用户菜单
        for (SysUserMenu userMenu: sysUserMenus){
            setCreateParam(userMenu,currentUserId,currentDate);
        }
        userMenuRepository.saveAll(sysUserMenus);
    }


    @Override
    public List<SysUserRole> getRolesByUserId(Long userId) {
        return userRoleRepository.findByUserId(userId);
    }

    @Override
    public void updateUserRole(List<SysUserRole> sysUserRoles, Long userId,Long currentUserId) {
        Date currentDate = new Date();
        //删除原来的用户角色
        userRoleRepository.deleteUserRoleByUserId(userId,currentUserId,currentDate);
        //保存新用户角色
        for (SysUserRole userRole: sysUserRoles){
            setCreateParam(userRole,currentUserId,currentDate);
        }
        userRoleRepository.saveAll(sysUserRoles);
    }

    @Override
    public List<String> queryMenuIdsByRoleId(Long roleId) {
        List<String> resultList = InstanceUtil.newArrayList();
        List<SysRoleMenu> list = roleMenuRepository.findByRoleId(roleId);
        for (SysRoleMenu roleMenu : list) {
            resultList.add(roleMenu.getMenuId().toString());
        }
        return resultList;
    }

    @Override
    public void updateRoleMenu(List<SysRoleMenu> sysRoleMenus, Long userId, Long currentUserId) {
        Date currentDate = new Date();
        //删除原来的角色菜单
        roleMenuRepository.deleteRoleMenuByRoleId(userId,currentUserId,currentDate);
        //保存新角色菜单
        setCreateParamBatch(sysRoleMenus,currentUserId,currentDate);

        roleMenuRepository.saveAll(sysRoleMenus);
    }

    //获取授权菜单
    @Override
    public List<SysMenu> queryAuthorizeByUserId(Long userId) {
        List<SysMenu> userMenus = userMenuRepository.findMenuByUserId(userId);
        List<SysUserRole> userRoles = userRoleRepository.findByUserId(userId);
        List<SysMenu> roleMenus = InstanceUtil.newArrayList();
        for (SysUserRole userRole:userRoles){
            List<SysMenu> temp= roleMenuRepository.findMenuByRoleId(userRole.getRoleId());
            roleMenus.addAll(temp);
        }
        //将用户菜单和用户角色的菜单合并一起并按树形排序
        List<SysMenu> result = InstanceUtil.newArrayList();
        result.addAll(userMenus);
        result.addAll(roleMenus);

        return menuService.formatList(result);
    }
    //查询用户所有权限
    @Override
    public List<String> queryPermissionByUserId(Long userId) {
        List<String> userPermission = userRepository.getUserMenuPermission(userId);
        List<String> rolePermission = userRepository.getUserRolePermission(userId);
        //合并去重
        List<String> result = Stream.concat(userPermission.stream(),rolePermission.stream()).distinct().collect(Collectors.toList());

        return result;
    }

    @Override
    public List<String> queryUserMenuName(Long userId) {
        List<SysDic> dics = dicService.findByType("CRUD");
        List<SysMenu> menus = userMenuRepository.findMenuByUserId(userId);
        //遍历两次拼接
        List<String> result = menus.stream().flatMap(i->
            dics.stream().map(m->i.getMenuName()+"("+m.getCodeText()+")")
        ).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<String> queryRoleMenuName(Long roleId) {
        List<SysDic> dics = dicService.findByType("CRUD");
        List<SysMenu> menus = roleMenuRepository.findMenuByRoleId(roleId);
        //遍历两次拼接
        List<String> result = menus.stream().flatMap(i->
                dics.stream().map(m->i.getMenuName()+"("+m.getCodeText()+")")
        ).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<SysMenu> queryMenusPermission() {
        List<SysMenu> menus = menuService.queryList();
        List<SysDic> dics = dicService.findByType("CRUD");
        List<SysMenu> result = menus.stream().flatMap(i-> dics.stream().map((SysDic m) ->{
            SysMenu menu = new SysMenu();
            menu.setId(i.getId());
            menu.setMenuName(i.getMenuName());
            menu.setPermission(m.getCode());
            menu.setPermissionText(m.getCodeText());
            return menu;
        })).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<Map<String, Object>> queryUserPermissions(SysUserMenu sysUserMenu) {
        List<SysUserMenu> userMenus = userMenuRepository.findByUserId(sysUserMenu.getUserId());
        List<Map<String, Object>> result = userMenus.stream().map(i->{
            Map<String, Object> data = InstanceUtil.newHashMap();
            data.put("menuId",i.getMenuId());
            data.put("permission",i.getPermission());
            return data;
        }).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<Map<String, Object>> queryRolePermissions(SysRoleMenu sysRoleMenu) {
        List<SysRoleMenu> roleMenus = roleMenuRepository.findByRoleId(sysRoleMenu.getRoleId());
        List<Map<String, Object>> result = roleMenus.stream().map(i->{
            Map<String, Object> data = InstanceUtil.newHashMap();
            data.put("menuId",i.getMenuId());
            data.put("permission",i.getPermission());
            return data;
        }).collect(Collectors.toList());
        return result;


    }

    public List<SysMenu> getChildMenu(Map<Long, List<SysMenu>> map, Long id) {
        List<SysMenu> menus = map.get(id);
        if (menus != null) {
            for (SysMenu sysMenu : menus) {
                if (sysMenu != null) {
                    sysMenu.setMenuBeans(getChildMenu(map, sysMenu.getId()));
                }
            }
        }
        return menus;
    }

}