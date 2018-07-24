package com.immortal.immortal4j.service.impl;

import com.immortal.immortal4j.base.BaseServiceImpl;
import com.immortal.immortal4j.dao.SysRoleRepository;
import com.immortal.immortal4j.entity.SysRole;
import com.immortal.immortal4j.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/7/22 16:29
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleRepository repository;

    @Override
    protected JpaRepository getDefaultRepository() {
        return repository;
    }
}