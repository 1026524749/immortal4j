package com.immortal.immortal4j.dao;

import com.immortal.immortal4j.entity.SysMenu;
import com.immortal.immortal4j.entity.SysRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/11 0:23
 */
public interface SysRoleMenuRepository extends JpaRepository<SysRoleMenu,Long> {
    public List<SysRoleMenu>  findByRoleId(Long roleId);

    @Query("update SysRoleMenu e set e.enable=0,e.updateBy=?2,e.updateTime=?3 where e.roleId=?1  and e.enable =1 ")
    @Modifying
    public void deleteRoleMenuByRoleId(Long roleId, Long currentUserId, Date currentDate);

    @Query("select m from SysMenu m ,SysRoleMenu e where e.menuId = m.id  and e.enable =1 and m.enable = 1")
    public List<SysMenu> findMenuByRoleId(Long roleId);
}
