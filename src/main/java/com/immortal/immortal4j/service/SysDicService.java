package com.immortal.immortal4j.service;

import com.immortal.immortal4j.base.BaseService;
import com.immortal.immortal4j.entity.SysDic;

import java.util.List;
import java.util.Map;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/7/24 0:04
 */
public interface SysDicService extends BaseService{

    /**
     * 根据关键字获取字典键值对
     * @param key
     * @return
     */
    public Map<String, String> queryDicByType(String key);

    /**
     * 获取全部字典键值对
     * @return
     */
    public Map<String, Map<String, String>> getAllDic();

    /**
     * 根据类型查找数据
     * @param key
     * @return
     */
    public List<SysDic> findByType(String key);
}