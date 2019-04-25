/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.amarone.model.article.entity.ArticleType;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年03月27日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
public interface IArticleTypeDao extends JpaRepository<ArticleType, Long> {

    ArticleType  queryById(Long id);
}
