package com.immortal.immortal4j.controller;

import com.immortal.immortal4j.base.BaseController;
import com.immortal.immortal4j.entity.SysDept;
import com.immortal.immortal4j.exception.BizException;
import com.immortal.immortal4j.service.SysDeptService;
import org.springframework.web.bind.annotation.*;

/**部门管理控制类
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/18 21:56
 */
@RestController
@RequestMapping(value = "/dept")
public class SysDeptController extends BaseController<SysDept>{

    private SysDeptService service;

    @PostMapping
    public void add(SysDept dept){
        service.update(dept);
    }
    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, SysDept dept){
        SysDept oDept = service.get(id);
        if (oDept == null){
            throw new BizException("部门不存在");
        }
        service.update(dept);
    }
}
