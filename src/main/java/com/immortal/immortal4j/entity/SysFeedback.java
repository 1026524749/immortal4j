package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/9 17:17
 */
@Entity
public class SysFeedback extends BaseEntity {
    /**
     * 类型
     */
    @Column(name = "type_")
    private String type;
    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * 内容
     */
    @Column(name = "content_")
    private String content;
    /**
     * 来源
     */
    @Column(name = "resource_")
    private String resource;
}
