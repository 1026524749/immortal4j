package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/9 16:47
 */
@Entity
public class SysNotice extends BaseEntity {
    /**
     * 公告标题
     */
    @Column(name = "notice_title")
    private String noticeTitle;
    /**
     * 公告类型
     */
    @Column(name = "notice_type")
    private String noticeType;
    /**
     * 发布时间
     */
    @Column(name = "send_time")
    private Date sendTime;
    /**
     * 信息来源
     */
    @Column(name = "info_sources")
    private String infoSources;
    /**
     * 来源地址
     */
    @Column(name = "sources_url")
    private String sourcesUrl;
    /**
     * 阅读次数
     */
    @Column(name = "reader_times")
    private Integer readerTimes;
    /**
     * 发布状态
     */
    @Column(name = "status_")
    private String status;
    /**
     * 内容
     */
    @Column(name = "content_")
    private String content;
}
