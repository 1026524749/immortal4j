package com.immortal.immortal4j.dao;

import com.immortal.immortal4j.entity.SysRole;
import com.immortal.immortal4j.entity.User;
import com.immortal.immortal4j.service.SysRoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/4 23:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private SysRoleService roleService;

    @Test
    public void test() throws Exception {
        SysRole role = new SysRole();
        role.setDeptId(1L);
        role.setDeptName("测试");
        role.setRoleType(2);
        //roleService.update(role);
    }

}
