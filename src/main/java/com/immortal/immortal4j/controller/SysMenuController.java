package com.immortal.immortal4j.controller;

import com.immortal.immortal4j.base.BaseController;
import com.immortal.immortal4j.entity.SysMenu;
import com.immortal.immortal4j.exception.BizException;
import com.immortal.immortal4j.query.PageParam;
import com.immortal.immortal4j.service.SysMenuService;
import com.immortal.immortal4j.support.HttpCode;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/8/27 15:13
 */
@RestController
@RequestMapping("/menu")
public class SysMenuController extends BaseController {
    @Autowired
    private SysMenuService service;

    @GetMapping(value = "/{id}")
    @RequiresPermissions("sys.base.menu.read")
    public Object get(@PathVariable Long id) {
        Object t = service.get(id);
        if (t == null) {
            throw new BizException(HttpCode.NOT_FOUND);
        }
        return setSuccess(t);
    }

    @DeleteMapping(value = "/{id}")
    @RequiresPermissions("sys.base.menu.delete")
    public Object delete(@PathVariable Long id) {
        service.del(id, getCurrentUser());
        return setSuccess();
    }

    @PostMapping
    @RequiresPermissions("sys.base.menu.create")
    public Object create(SysMenu entity) {
        service.update(entity, getCurrentUser());
        return setSuccess();
    }

    @PutMapping
    @RequiresPermissions("sys.base.menu.update")
    public Object update(SysMenu entity) {
        Object temp = service.get(entity.getId());
        if (temp == null) {
            throw new BizException(HttpCode.NOT_FOUND);
        }
        service.update(entity, getCurrentUser());
        return setSuccess();
    }

    @GetMapping
    @RequiresPermissions("sys.base.menu.read")
    public Object all() {
        return setSuccess(service.list());
    }

    @GetMapping(value = "/page")
    @RequiresPermissions("sys.base.menu.read")
    public Object query(PageParam pageParam) {
        PageRequest pageRequest = PageRequest.of(pageParam.getPage() - 1, pageParam.getPageSize());
        return setSuccess(service.page(pageRequest));
    }
}