package com.immortal.immortal4j.dao;

import com.immortal.immortal4j.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.PrivateKey;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/4 23:03
 */
public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * 根据用户名查询
     * @param userName 用户名
     * @return 用户
     */
    User findByUserName(String userName);

    /**
     * 根据用户名或者用户邮箱查询
     * @param userName 用户名
     * @param email 邮箱
     * @return 用户
     */
    User findByUserNameOrEmail(String userName, String email);


}
