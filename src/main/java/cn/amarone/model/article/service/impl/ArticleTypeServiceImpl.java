/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.amarone.model.article.dao.IArticleTypeDao;
import cn.amarone.model.article.entity.ArticleType;
import cn.amarone.model.article.service.IArticleTypeService;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年04月17日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
@Service
public class ArticleTypeServiceImpl implements IArticleTypeService {

    @Autowired
    private IArticleTypeDao articleTypeDao;

    @Override
    public List<ArticleType> getAllType() {
        return articleTypeDao.findAll();
    }

    @Override
    public ArticleType queryById(Long id) {
        // TODO
        return null;
    }
}