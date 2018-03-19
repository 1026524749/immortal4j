package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/10 19:54
 */
@Entity
public class SysEmailTemplate extends BaseEntity {
    /**
     * 邮件名称
     */
    @Column(name = "sender_name")
    private String senderName;
    /**
     * 发送邮件帐号
     */
    @Column(name = " sender_account")
    private String senderAccount;
    /**
     * 排序号
     */
    @Column(name = "sort_")
    private Integer sort;
    /**
     * 标题模版
     */
    @Column(name = "title_")
    private String title;
    /**
     * 内容模板
     */
    @Column(name = "template_")
    private String template;
}
