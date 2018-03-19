package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/10 20:53
 */
@Entity
public class SysDic extends BaseEntity {
    @Column(name = "type_")
    private String type;
    @Column(name = "code_")
    private String code;
    private String codeText;
    private Integer sortNo;
    @Column(name = "editable_")
    private Boolean editable;
    @Column(name = "parent_type")
    private String parentType;
    @Column(name = "parent_code")
    private String parentCode;
}
