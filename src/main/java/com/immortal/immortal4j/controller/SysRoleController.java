package com.immortal.immortal4j.controller;

import com.immortal.immortal4j.base.BaseController;
import com.immortal.immortal4j.entity.SysRole;
import com.immortal.immortal4j.exception.BizException;
import com.immortal.immortal4j.query.PageParam;
import com.immortal.immortal4j.query.PageResult;
import com.immortal.immortal4j.service.SysRoleService;
import com.immortal.immortal4j.support.HttpCode;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/7/15 15:53
 */
@RestController
@RequestMapping("/role")
public class SysRoleController extends BaseController {
    @Autowired
    private SysRoleService service;
    @GetMapping(value = "/{id}")
    @RequiresPermissions("sys.base.role.read")
    public Object get(@PathVariable Long id) {
        SysRole t = service.get(id);
        if (t == null) {
            throw new BizException(HttpCode.NOT_FOUND);
        }
        return setSuccess(t);
    }

    @DeleteMapping(value = "/{id}")
    @RequiresPermissions("sys.base.role.delete")
    public Object delete(@PathVariable Long id) {
        service.del(id,getCurrentUser());
        return setSuccess();
    }

    @PostMapping
    @RequiresPermissions("sys.base.role.create")
    public Object create(SysRole entity) {
        service.update(entity,getCurrentUser());
        return setSuccess();
    }

    @PutMapping
    @RequiresPermissions("sys.base.role.update")
    public Object update(SysRole entity) {
        SysRole temp = service.get(entity.getId());
        if (temp == null) {
            throw new BizException(HttpCode.NOT_FOUND);
        }
        service.update(entity,getCurrentUser());
        return setSuccess();
    }

    @GetMapping
    @RequiresPermissions("sys.base.role.read")
    public Object all() {
        return setSuccess(service.list());
    }

    @GetMapping(value = "/page")
    @RequiresPermissions("sys.base.role.read")
    public Object query(PageParam pageParam) {
        PageRequest pageRequest = PageRequest.of(pageParam.getPage()-1,pageParam.getPageSize());
        return setSuccess(service.page(pageRequest));
    }
}