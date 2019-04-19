/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.article.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 文章分类
 *
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年03月27日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
@Data
@Entity
@Table(name = "sys_article_type")
public class ArticleType implements Serializable {

    @Id
    private Long id;

    @Column(name = "name", length = 20)
    private String name;


    @Column(name = "content", length = 1000, nullable = true)
    private String content;

    /**
     * 概要
     */
    @Column(name = "summary", length = 255, nullable = true)
    private String summary;

    /**
     * 该分类的内容数量
     */
    @Column(name = "postCount", length = 6, nullable = true)
    private Integer postCount;

    /**
     * 图标
     */
    @Column(name = "icon", length = 255, nullable = true)
    private String icon;

    /**
     * 排序编码
     */
    @Column(name = "orderNum", length = 3, nullable = true)
    private Integer orderNum;

    /**
     * 上级分类ID
     */
    @Column(name = "parentId", length = 18, nullable = true)
    private Long parentId;

    /**
     * 关键字SEO
     */
    @Column(name = "metaKeywrods", length = 100, nullable = true)
    private String metaKeywrods;

    /**
     * 关键描述内容SEO
     */
    @Column(name = "metaDescription", length = 255, nullable = true)
    private String metaDescription;


}