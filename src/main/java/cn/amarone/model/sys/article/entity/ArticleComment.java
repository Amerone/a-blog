/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.sys.article.entity;

import java.io.Serializable;

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
@Table(name = "sys_article_comment")
public class ArticleComment implements Serializable {

    @Id
    private Long id;

    @Column(name = "content", length = 255)
    private String content;

    /**
     * 回复评论的ID
     */
    @Column(name = "parentId", length = 18, nullable = true)
    private Long parentId;

    /**
     * 回复用户ID
     */
    @Column(name = "userId", length = 18, nullable = true)
    private Long userId;


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
     * 置顶等级
     */
    @Column(name = "level", length = 6, nullable = true)
    private Integer level;

    /**
     * 评论状态
     */
    @Column(name = "status", length = 1, nullable = true)
    private String status;
    
}