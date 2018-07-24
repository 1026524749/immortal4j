package com.immortal.immortal4j.service.impl;

import com.immortal.immortal4j.base.BaseServiceImpl;
import com.immortal.immortal4j.dao.SysDicRepository;
import com.immortal.immortal4j.entity.SysDic;
import com.immortal.immortal4j.entity.SysRole;
import com.immortal.immortal4j.service.SysDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/7/24 0:05
 */
@Service
public class SysDicServiceImpl extends BaseServiceImpl implements SysDicService {
    @Autowired
    private SysDicRepository repository;

    @Override
    protected JpaRepository getDefaultRepository() {
        return repository;
    }

    @Override
    public Map<String, String> queryDicByType(String key) {
        repository.findByType(key);
        return null;
    }

    @Override
    public Map<String, Map<String, String>> getAllDic() {
        Sort sort = new Sort(Sort.Direction.DESC,"type","sortNo");
        repository.findAll(sort);
        return null;
    }
}