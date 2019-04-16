/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.sys.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.amarone.model.sys.article.entity.Article;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年03月27日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
public interface IArticleDao extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {

    Article queryById(Long id);

}
