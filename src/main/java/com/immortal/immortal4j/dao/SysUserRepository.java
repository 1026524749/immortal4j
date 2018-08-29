package com.immortal.immortal4j.dao;

import com.immortal.immortal4j.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/11 0:25
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    //查询用户的权限信息
    @Query("select CONCAT(menu.permission,'.',um.permission) " +
            "from SysMenu menu " +
            "join SysUserMenu um on um.menuId=menu.id " +
            "where length(menu.permission)>0 and um.userId=?1")
    public List<String> getUserMenuPermission(Long userId);

    @Query("select CONCAT(menu.permission,'.',rm.permission) " +
            "from SysMenu menu " +
            "join SysRoleMenu rm on rm.menuId=menu.id " +
            "join SysUserRole ur on ur.roleId=rm.roleId " +
            "where length(menu.permission)>0 and ur.userId=?1")
    public List<String> getUserRolePermission(Long userId);
}
