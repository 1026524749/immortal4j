package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/9 15:14
 */
@Entity
public class SysSession extends BaseEntity {
    private String sessionId;

    @Column(name = "account_")
    private String account;

    @Column(name = "ip_")
    private String ip;

    private Date startTime;
}
