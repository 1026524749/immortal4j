package com.immortal.immortal4j.service.impl;

import com.immortal.immortal4j.base.BaseEntity;
import com.immortal.immortal4j.base.BaseServiceImpl;
import com.immortal.immortal4j.dao.SysMenuRepository;
import com.immortal.immortal4j.entity.SysMenu;
import com.immortal.immortal4j.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/7/24 0:00
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuRepository repository;

    @Override
    protected JpaRepository getDefaultRepository() {
        return repository;
    }

    @Override
    public BaseEntity get(Long id) {
        SysMenu menu= (SysMenu)super.get(id);
        if(menu.getParentId() != null && menu.getParentId() != 0){
            SysMenu parent = (SysMenu)super.get(menu.getParentId());
            if (parent != null){
                menu.setParentName(parent.getMenuName());
            }else {
                menu.setParentId(null);
            }
        }
        return menu;
    }

    @Override
    public List<SysMenu> queryList() {
        return null;
    }

    @Override
    public List<Object> queryTreeList() {
        return null;
    }
}