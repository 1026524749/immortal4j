package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/10 20:52
 */
@Entity
public class SysEmail extends BaseEntity {
    /**
     * 邮件名称
     */
    @Column(name = "email_name")
    private String emailName;
    /**
     * 使用发送
     */
    @Column(name = "sender_")
    private String sender;
    /**
     * 发送标题
     */
    @Column(name = "email_title")
    private String emailTitle;
    /**
     * 发送内容
     */
    @Column(name = "email_content")
    private String emailContent;
}
