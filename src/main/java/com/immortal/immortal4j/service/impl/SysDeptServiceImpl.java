package com.immortal.immortal4j.service.impl;

import com.immortal.immortal4j.base.BaseServiceImpl;
import com.immortal.immortal4j.dao.SysDeptRepository;
import com.immortal.immortal4j.dao.SysDicRepository;
import com.immortal.immortal4j.entity.SysDept;
import com.immortal.immortal4j.exception.BizException;
import com.immortal.immortal4j.service.SysDeptService;
import com.immortal.immortal4j.support.HttpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/7/24 0:03
 */
@Service
public class SysDeptServiceImpl extends BaseServiceImpl implements SysDeptService {
    @Autowired
    private SysDeptRepository repository;

    @Override
    protected JpaRepository getDefaultRepository() {
        return repository;
    }

    @Override
    public SysDept queryById(Long id) {
        SysDept dept = (SysDept) super.get(id);
        if (dept == null){
            return null;
        }
        SysDept parent = (SysDept)super.get(dept.getParentId());
        if (parent != null){
            dept.setParentName(parent.getDeptName());
        }
        return dept;
    }
}