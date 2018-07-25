package com.immortal.immortal4j.service.impl;

import com.immortal.immortal4j.base.BaseEntity;
import com.immortal.immortal4j.base.BaseServiceImpl;
import com.immortal.immortal4j.dao.SysMenuRepository;
import com.immortal.immortal4j.entity.SysDic;
import com.immortal.immortal4j.entity.SysMenu;
import com.immortal.immortal4j.service.SysDicService;
import com.immortal.immortal4j.service.SysMenuService;
import com.immortal.immortal4j.utils.InstanceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/7/24 0:00
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuRepository repository;
    @Autowired
    private SysDicService sysDicService;

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
        Sort sort = new Sort(Sort.Direction.DESC,"parentId","sortNo");
        List<SysMenu> pageInfo = repository.findAll(sort);
        return formatList(pageInfo);

    }

    @Override
    public List<Object> queryTreeList() {
        Sort sort = new Sort(Sort.Direction.DESC,"parentId","sortNo");
        List<SysMenu> pageInfo = repository.findAll(sort);
        pageInfo = formatList(pageInfo);
        List<SysDic> sysDics = sysDicService.findByType("CURD");
        List<Object> resultList = InstanceUtil.newArrayList();
        for (SysMenu sysMenu : pageInfo) {
            resultList.add(sysMenu);
            if (sysMenu.getLeaf()!=0){
                //如果是叶子节点，多添加几个正删改查等子菜单
                List<Map<String, Object>> dicMaps = InstanceUtil.newArrayList();
                for (SysDic sysDic : sysDics) {
                    if (!"read".equals(sysDic.getCode())) {
                        Map<String, Object> dicMap = InstanceUtil.transBean2Map(sysDic);
                        dicMap.put("id", "D" + sysDic.getId());
                        dicMap.put("menuName", sysDic.getCodeText());
                        dicMap.put("parentId", sysMenu.getId().toString());
                        dicMaps.add(dicMap);
                    }
                }
                resultList.addAll(resultList.indexOf(sysMenu) + 1, dicMaps);
            }
        }
        return resultList;
    }

    /**
     * 将菜单按照树结构排序
     * @param data
     * @return
     */
    private List<SysMenu> formatList(List<SysMenu> data){
        List<SysMenu> resultList = InstanceUtil.newArrayList();
        Map<String, String> menuTypeMap = sysDicService.queryDicByType("MENUTYPE");
        Map<Long, Integer> leafMap = InstanceUtil.newHashMap();
        Map<Long, List<SysMenu>> map = InstanceUtil.newHashMap();
        for (SysMenu sysMenu : data) {
            if (sysMenu != null) {
                //设置菜单类型名字
                if (sysMenu.getMenuType() != null) {
                    sysMenu.setTypeName(menuTypeMap.get(sysMenu.getMenuType().toString()));
                }
                //计算父节点的子节点数，用于判断是否是叶子节点
                if (leafMap.get(sysMenu.getParentId()) == null) {
                    leafMap.put(sysMenu.getParentId(), 0);
                }
                leafMap.put(sysMenu.getParentId(), leafMap.get(sysMenu.getParentId()) + 1);
                if (map.get(sysMenu.getParentId()) == null) {
                    map.put(sysMenu.getParentId(), new ArrayList<SysMenu>());
                }
                //将叶子节点按照父节点分类保存
                map.get(sysMenu.getParentId()).add(sysMenu);
                //加入根节点
                if (sysMenu.getParentId() == null || sysMenu.getParentId() == 0) {
                    resultList.add(sysMenu);
                }
            }
        }
        for (SysMenu sysMenu : data) {
            if (leafMap.get(sysMenu.getId()) != null && leafMap.get(sysMenu.getId()) > 0) {
                sysMenu.setLeaf(0);
            }
            if (map.get(sysMenu.getId()) != null) {
                resultList.addAll(resultList.indexOf(sysMenu) + 1, map.get(sysMenu.getId()));
            }
        }
        return resultList;
    }
}