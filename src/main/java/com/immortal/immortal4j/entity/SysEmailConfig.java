package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/10 20:51
 */
@Entity
public class SysEmailConfig extends BaseEntity {
    /**
     * SMTP服务器
     */
    @Column(name = "smtp_host")
    private String smtpHost;
    /**
     * SMTP服务器端口
     */
    @Column(name = "smtp_port")
    private String smtpPort;
    /**
     * 发送方式
     */
    @Column(name = "send_method")
    private String sendMethod;
    /**
     * 名称
     */
    @Column(name = "sender_name")
    private String senderName;
    /**
     * 发邮件邮箱账号
     */
    @Column(name = "sender_account")
    private String senderAccount;
    /**
     * 发邮件邮箱密码
     */
    @Column(name = "sender_password")
    private String senderPassword;
}
