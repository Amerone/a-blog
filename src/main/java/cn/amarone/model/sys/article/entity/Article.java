/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.sys.article.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年03月27日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
@Data
@Entity
@Table(name = "sys_article")
public class Article implements Serializable {

    @Id
    private Long id;

    /**
     * 文章标题
     */
    @Column(name = "title", length = 100, nullable = true)
    private String title;

    /**
     * 文章内容
     */
    @Column(name = "content", length = 1000, nullable = true)
    private String content;

    /**
     * 支持人数
     */
    @Column(name = "voteUp", length = 6, nullable = true)
    private long voteUp;

    /**
     * 反对人数
     */
    @Column(name = "voteDown", length = 6, nullable = true)
    private long voteDown;

    /**
     * 访问量
     */
    @Column(name = "viewCount", length = 6, nullable = true)
    private long viewCount;

    /**
     * 置顶等级（默认为0，等级越高越置顶
     */
    @Column(name = "level", length = 3, nullable = true)
    private Integer level;

    /**
     * 是否精华 0 是  1 否
     */
    @Column(name = "recommend", length = 1, nullable = true)
    private String recommend;

    /**
     * 0 发布  1 草稿
     */
    @Column(name = "status", length = 1, nullable = true)
    private String status;

    /**
     * 作者id
     */
    @Column(name = "userId", length = 18, nullable = true)
    private Long userId;

    /**
     * 分类ID
     */
    @Column(name = "categoryId", length = 18, nullable = true)
    private Long categoryId;

    /**
     * 创建时间
     */
    @Column(name = "createDate", nullable = false)
    private Date createDate;

    /**
     * 更新时间
     */
    @Column(name = "updateDate", nullable = false)
    private Date updateDate;

    private String userName;
    private String avatar;

}