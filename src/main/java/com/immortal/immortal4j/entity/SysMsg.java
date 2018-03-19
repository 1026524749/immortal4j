package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/9 17:05
 */
@Entity
public class SysMsg extends BaseEntity {
    /**
     * 平台编号
     */
    @Column(name = "biz_id")
    private String bizId;
    /**
     * 类型
     */
    @Column(name = "type_")
    private String type;
    /**
     * 接收短信号码
     */
    @Column(name = "phone_")
    private String phone;
    /**
     * 短信内容
     */
    @Column(name = "content_")
    private String content;
    /**
     * 发送状态
     */
    @Column(name = "send_state")
    private String sendState;
}
