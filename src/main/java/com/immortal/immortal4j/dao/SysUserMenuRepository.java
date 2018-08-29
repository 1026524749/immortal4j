package com.immortal.immortal4j.dao;

import com.immortal.immortal4j.entity.SysMenu;
import com.immortal.immortal4j.entity.SysUserMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/11 0:26
 */
public interface SysUserMenuRepository extends JpaRepository<SysUserMenu, Long> {
    public List<SysUserMenu> findByUserId(Long userId);

    @Query("update SysUserMenu e set e.enable=0,e.updateBy=?2,e.updateTime=?3 where e.userId=?1  and e.enable =1 ")
    @Modifying
    public void deleteUserMenuByUserId(Long userId, Long currentUserId, Date currentDate);

    @Query("select m from SysMenu m ,SysUserMenu e where e.menuId = m.id  and e.enable =1 and m.enable = 1")
    public List<SysMenu> findMenuByUserId(Long userId);
}
