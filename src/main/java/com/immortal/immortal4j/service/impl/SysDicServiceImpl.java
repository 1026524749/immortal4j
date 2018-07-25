package com.immortal.immortal4j.service.impl;

import com.immortal.immortal4j.base.BaseServiceImpl;
import com.immortal.immortal4j.dao.SysDicRepository;
import com.immortal.immortal4j.entity.SysDic;
import com.immortal.immortal4j.entity.SysRole;
import com.immortal.immortal4j.service.SysDicService;
import com.immortal.immortal4j.utils.InstanceUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
        List<SysDic> list = repository.findByType(key);
        Map<String, String> resultMap = InstanceUtil.newHashMap();
        for (SysDic sysDic : list) {
            resultMap.put(sysDic.getCode(), sysDic.getCodeText());
        }
        return resultMap;
    }

    @Override
    public Map<String, Map<String, String>> getAllDic() {
        Sort sort = new Sort(Sort.Direction.DESC,"type","sortNo");
        List<SysDic> list = repository.findAll(sort);
        Map<String, Map<String, String>> resultMap = InstanceUtil.newHashMap();
        for (SysDic sysDic : list) {
            if (sysDic != null) {
                String key = sysDic.getType();
                if (resultMap.get(key) == null) {
                    Map<String, String> dicMap = InstanceUtil.newHashMap();
                    resultMap.put(key, dicMap);
                }
                if (StringUtils.isNotBlank(sysDic.getParentCode())) {
                    resultMap.get(key).put(sysDic.getParentCode() + sysDic.getCode(), sysDic.getCodeText());
                } else {
                    resultMap.get(key).put(sysDic.getCode(), sysDic.getCodeText());
                }
            }
        }
        return resultMap;
    }

    @Override
    public List<SysDic> findByType(String key) {
        return repository.findByType(key);
    }
}