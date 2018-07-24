package com.immortal.immortal4j.service;

import com.immortal.immortal4j.base.BaseService;
import com.immortal.immortal4j.entity.SysMenu;

import java.util.List;
import java.util.Map;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/7/23 23:59
 */
public interface SysMenuService extends BaseService{
    /**
     * 获取所有的菜单
     * @return
     */
    public List<SysMenu> queryList();

    /**
     * 获取树形结构菜单
     * @return
     */
    public List<Object> queryTreeList();
}