package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/9 15:13
 */
@Entity
public class SysUnit extends BaseEntity {
    private String unitName;
    @Column(name = "principal_")
    private String principal;
    @Column(name = "phone_")
    private String phone;
    @Column(name = "address_")
    private String address;
    @Column(name = "sort_")
    private Integer sort;
}
