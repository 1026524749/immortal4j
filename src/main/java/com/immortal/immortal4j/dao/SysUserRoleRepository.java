package com.immortal.immortal4j.dao;

import com.immortal.immortal4j.entity.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/11 0:27
 */
public interface SysUserRoleRepository extends JpaRepository<SysUserRole, Long> {
    public List<SysUserRole> findByUserId(Long userId);

    @Query("update SysUserRole e set e.enable=0,e.updateBy=?2,e.updateTime=?3 where e.userId=?1  and e.enable =1 ")
    @Modifying
    public void deleteUserRoleByUserId(Long userId, Long currentUserId, Date currentDate);
}
