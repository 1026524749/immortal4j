package com.immortal.immortal4j.dao;

import com.immortal.immortal4j.entity.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/11 0:14
 */
public interface SysMenuRepository extends JpaRepository<SysMenu,Long>{

    /**
     * 查询所有菜单权限
     * @return
     */
    @Query(value = "select CONCAT(m.id_, code_) as value, CONCAT(menu_name, code_text) as text " +
            "from sys_menu m " +
            "join sys_dic_index di on  di.key_='CRUD' " +
            "join sys_dic d on d.index_id=di.id_ " +
            "order by m.id_",nativeQuery = true)
    public List<Map<String,String>> getPermissions();
}
