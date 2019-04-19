/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.article.service;

import java.util.List;

import cn.amarone.model.article.entity.ArticleType;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年04月17日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
public interface IArticleTypeService {

    /**
     * 获取所有文章分类
     *
     * @return ArticleTypes
     */
    List<ArticleType> getAllType();

    ArticleType queryById(Long id);
}
