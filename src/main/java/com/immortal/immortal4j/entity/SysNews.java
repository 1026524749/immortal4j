package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/9 16:49
 */
@Entity
public class SysNews extends BaseEntity {
    /**
     * 新闻标题
     */
    @Column(name = "news_title")
    private String newsTitle;
    /**
     * 新闻类型
     */
    @Column(name = "news_type")
    private String newsType;
    /**
     * 发布时间
     */
    @Column(name = "send_time")
    private Date sendTime;
    /**
     * 作者
     */
    @Column(name = "author_")
    private String author;
    /**
     * 编辑
     */
    @Column(name = "editor_")
    private String editor;
    /**
     * Tag标签
     */
    @Column(name = "tags_")
    private String tags;
    /**
     * 关键字
     */
    @Column(name = "keys_")
    private String keys;
    /**
     * 内容
     */
    @Column(name = "content_")
    private String content;
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
}
