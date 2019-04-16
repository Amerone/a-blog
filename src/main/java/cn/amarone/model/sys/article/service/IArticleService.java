/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.sys.article.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.amarone.model.sys.article.entity.Article;

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
}
