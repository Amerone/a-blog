/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.article.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.amarone.model.article.entity.Article;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年03月27日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
public interface IArticleService {


    /**
     * 获取发布的文章
     *
     * @return Articles
     */
    Page<Article> getArticleByPage(Pageable pageable) throws Exception;

    /**
     * 文章详情
     *
     * @param id 文章id
     */
    Article queryArticle(Long id) throws Exception;

    /**
     * 根据分类查询文章
     *
     * @param pageable 分页
     * @param typeId   分类id
     */
    Page<Article> queryByType(Pageable pageable, Long typeId) throws Exception;
}
