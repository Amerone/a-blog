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
import org.springframework.web.bind.annotation.ResponseBody;

import cn.amarone.model.article.entity.Article;
import cn.amarone.model.article.entity.ArticleType;
import cn.amarone.model.article.service.IArticleService;
import cn.amarone.model.article.service.IArticleTypeService;
import cn.amarone.model.sys.common.BaseController;
import cn.amarone.model.user.service.ISysUserService;
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
        ArticleType typeInfo = articleTypeService.queryById(Long.valueOf(articleTypeId));
        req.setAttribute("typeInfo", typeInfo);

        // 分类文章信息
        Sort sort = new Sort(Sort.Direction.DESC, "updateDate");
        PageRequest pageReq = PageRequest.of(0, 20, sort);
        Page<Article> pageInfo = articleService.queryByType(pageReq, typeInfo.getId());
        sysUserService.getAccInfo(pageInfo);
        req.setAttribute("articles", pageInfo);

        req.setAttribute("currentCategoryId", typeInfo.getId()); // 文章分类id

        return "main/article/typeArt";
    }


    @GetMapping("/{articleTypeId}/{pageNum}")
    @ResponseBody
    public Page<Article> typeArticle(@PathVariable String articleTypeId, @PathVariable int pageNum) throws Exception {

        ArticleType typeInfo = articleTypeService.queryById(Long.valueOf(articleTypeId));
        req.setAttribute("typeInfo", typeInfo);
        req.setAttribute("currentCategoryId", typeInfo.getId()); // 文章分类id

        // 分类文章信息
        Sort sort = new Sort(Sort.Direction.DESC, "updateDate");
        PageRequest pageReq = PageRequest.of(pageNum, 10, sort);
        Page<Article> pageInfo = articleService.queryByType(pageReq, Long.valueOf(articleTypeId));
        sysUserService.getAccInfo(pageInfo);
        return pageInfo;
    }
}