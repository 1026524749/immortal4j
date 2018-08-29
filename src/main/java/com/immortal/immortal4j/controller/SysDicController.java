package com.immortal.immortal4j.controller;

import com.immortal.immortal4j.base.BaseController;
import com.immortal.immortal4j.entity.SysDic;
import com.immortal.immortal4j.exception.BizException;
import com.immortal.immortal4j.query.PageParam;
import com.immortal.immortal4j.service.SysDicService;
import com.immortal.immortal4j.support.HttpCode;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/8/27 15:08
 */
@RestController
@RequestMapping("/dic")
public class SysDicController extends BaseController {
    @Autowired
    private SysDicService service;

    @GetMapping(value = "/{id}")
    @RequiresPermissions("sys.base.dic.read")
    public Object get(@PathVariable Long id) {
        Object t = service.get(id);
        if (t == null) {
            throw new BizException(HttpCode.NOT_FOUND);
        }
        return setSuccess(t);
    }

    @DeleteMapping(value = "/{id}")
    @RequiresPermissions("sys.base.dic.delete")
    public Object delete(@PathVariable Long id) {
        service.del(id, getCurrentUser());
        return setSuccess();
    }

    @PostMapping
    @RequiresPermissions("sys.base.dic.create")
    public Object create(SysDic entity) {
        service.update(entity, getCurrentUser());
        return setSuccess();
    }

    @PutMapping
    @RequiresPermissions("sys.base.dic.update")
    public Object update(SysDic entity) {
        Object temp = service.get(entity.getId());
        if (temp == null) {
            throw new BizException(HttpCode.NOT_FOUND);
        }
        service.update(entity, getCurrentUser());
        return setSuccess();
    }

    @GetMapping
    @RequiresPermissions("sys.base.dic.read")
    public Object all() {
        return setSuccess(service.list());
    }

    @GetMapping(value = "/page")
    @RequiresPermissions("sys.base.dic.read")
    public Object query(PageParam pageParam) {
        PageRequest pageRequest = PageRequest.of(pageParam.getPage() - 1, pageParam.getPageSize());
        return setSuccess(service.page(pageRequest));
    }
}