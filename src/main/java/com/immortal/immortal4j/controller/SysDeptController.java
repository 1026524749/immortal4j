package com.immortal.immortal4j.controller;

import com.immortal.immortal4j.base.BaseController;
import com.immortal.immortal4j.entity.SysDept;
import com.immortal.immortal4j.exception.BizException;
import com.immortal.immortal4j.query.PageParam;
import com.immortal.immortal4j.service.SysDeptService;
import com.immortal.immortal4j.support.HttpCode;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/8/27 15:09
 */
@RestController
@RequestMapping("/dept")
public class SysDeptController extends BaseController {
    @Autowired
    private SysDeptService service;

    @GetMapping(value = "/{id}")
    @RequiresPermissions("sys.base.dept.read")
    public Object get(@PathVariable Long id) {
        Object t = service.get(id);
        if (t == null) {
            throw new BizException(HttpCode.NOT_FOUND);
        }
        return setSuccess(t);
    }

    @DeleteMapping(value = "/{id}")
    @RequiresPermissions("sys.base.dept.delete")
    public Object delete(@PathVariable Long id) {
        service.del(id, getCurrentUser());
        return setSuccess();
    }

    @PostMapping
    @RequiresPermissions("sys.base.dept.create")
    public Object create(SysDept entity) {
        service.update(entity, getCurrentUser());
        return setSuccess();
    }

    @PutMapping
    @RequiresPermissions("sys.base.dept.update")
    public Object update(SysDept entity) {
        Object temp = service.get(entity.getId());
        if (temp == null) {
            throw new BizException(HttpCode.NOT_FOUND);
        }
        service.update(entity, getCurrentUser());
        return setSuccess();
    }

    @GetMapping
    @RequiresPermissions("sys.base.dept.read")
    public Object all() {
        return setSuccess(service.list());
    }

    @GetMapping(value = "/page")
    @RequiresPermissions("sys.base.dept.read")
    public Object query(PageParam pageParam) {
        PageRequest pageRequest = PageRequest.of(pageParam.getPage() - 1, pageParam.getPageSize());
        return setSuccess(service.page(pageRequest));
    }
}