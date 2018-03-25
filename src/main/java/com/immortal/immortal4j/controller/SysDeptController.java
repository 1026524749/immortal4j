package com.immortal.immortal4j.controller;

import com.immortal.immortal4j.base.BaseController;
import com.immortal.immortal4j.entity.SysDept;
import com.immortal.immortal4j.exception.BizException;
import com.immortal.immortal4j.exception.NotFoundException;
import com.immortal.immortal4j.support.PageParam;
import com.immortal.immortal4j.support.PageResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**部门管理控制类
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/18 21:56
 */
@RestController
@RequestMapping(value = "/dept")
public class SysDeptController extends BaseController<SysDept>{

    @GetMapping(value = "/{id}")
    @RequiresPermissions("sys.base.dept.read")
    public SysDept get(@PathVariable Long id){
        SysDept t = service.get(id);
        if (t == null){
            throw new NotFoundException("部门不存在");
        }
        return t;
    }

    @DeleteMapping(value = "/{id}")
    @RequiresPermissions("sys.base.dept.delete")
    public void delete(@PathVariable Long id){
        super.del(id);
    }

    @PostMapping
    @RequiresPermissions("sys.base.dept.create")
    public void create(SysDept param){
        super.update(param);
    }
    @PutMapping(value = "/{id}")
    @RequiresPermissions("sys.base.dept.update")
    public void update(@PathVariable Long id, SysDept param){
        if (!id.equals(param.getId()))
        {
            throw new BizException("id冲突");
        }
        SysDept temp = service.get(id);
        if (temp == null){
            throw new BizException("部门不存在");
        }
        super.update(param);
    }

    @GetMapping
    @RequiresPermissions("sys.base.dept.read")
    public List<SysDept> listAll(){
        return super.list();
    }

    @GetMapping(value = "/page")
    @RequiresPermissions("sys.base.dept.read")
    public PageResult pageAll(PageParam pageParam){
        return super.page(pageParam);
    }

}
