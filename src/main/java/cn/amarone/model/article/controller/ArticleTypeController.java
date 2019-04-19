/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.amarone.model.article.entity.Article;
import cn.amarone.model.article.service.IArticleService;
import cn.amarone.model.article.service.IArticleTypeService;
import cn.amarone.model.sys.common.BaseController;
import cn.amarone.model.sys.user.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年04月17日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
@Slf4j
@Controller
@RequestMapping("/articleType")
public class ArticleTypeController extends BaseController {

    @Autowired
    private IArticleTypeService articleTypeService;

    @Autowired
    private IArticleService articleService;

    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("/{articleTypeId}")
    public String getTypeArticle(@PathVariable String articleTypeId) throws Exception {

        // 分类信息


        // 分类文章信息
        Sort sort = new Sort(Sort.Direction.DESC, "updateDate");
        PageRequest pageReq = PageRequest.of(0, 20, sort);
        Page<Article> pageInfo = articleService.getArticleByPage(pageReq);
        sysUserService.getAccInfo(pageInfo);
        req.setAttribute("articles", pageInfo);

        return "main/article/typeArt";
    }
}