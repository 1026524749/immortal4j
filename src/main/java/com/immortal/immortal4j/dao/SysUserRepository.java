package com.immortal.immortal4j.dao;

import com.immortal.immortal4j.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/11 0:25
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
}
