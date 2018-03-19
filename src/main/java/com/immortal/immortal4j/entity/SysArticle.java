package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;

import javax.persistence.*;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/10 20:55
 */
@Entity
public class SysArticle extends BaseEntity {
    /**
     * 类型
     */
    @Column(name = "type_")
    private String type;
    /**
     * 作者
     */
    @Column(name = "author_")
    private String author;
    /**
     * 标题
     */
    @Column(name = "title_")
    private String title;
    /**
     * 内容
     */
    @Column(name = "content_")
    private String content;
    /**
     * 外部链接
     */
    @Column(name = "out_url")
    private String outUrl;
    /**
     * seo关键字
     */
    @Column(name = "seo_keyword")
    private String seoKeyword;
    /**
     * seo描述
     */
    @Column(name = "seo_description")
    private String seoDescription;
    /**
     * 是否置顶
     */
    @Column(name = "is_top")
    private Integer isTop;
}
