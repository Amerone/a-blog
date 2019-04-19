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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import cn.amarone.model.article.entity.Article;
import cn.amarone.model.sys.common.BaseController;
import cn.amarone.model.sys.common.exception.BizException;
import cn.amarone.model.sys.user.service.ISysUserService;
import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年03月29日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
@Slf4j
@Controller
@RequestMapping("/article")
public class ArticlesController extends BaseController {

    @Autowired
    private cn.amarone.model.article.service.IArticleService articleService;

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 获取置顶文章
     */
    @RequestMapping(value = "/top", method = RequestMethod.GET)
    @ResponseBody
    public Page<Article> getTopArticles(int page) throws Exception {
        Sort sort = new Sort(Sort.Direction.DESC, "level");
        PageRequest pageReq = PageRequest.of(page, 3, sort);
        Page<Article> pageInfo = articleService.getArticleByPage(pageReq);
        sysUserService.getAccInfo(pageInfo);
        return pageInfo;
    }

    /**
     * 综合文章
     */
    @RequestMapping(value = "/synthesize", method = RequestMethod.GET)
    @ResponseBody
    public Page<Article> getSynthesizeArticles(int page) throws Exception {

        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        orders.add(new Sort.Order(Sort.Direction.ASC, "level"));
        orders.add(new Sort.Order(Sort.Direction.DESC, "updateDate"));
        PageRequest pageRqe = PageRequest.of(page, 5, new Sort(orders));

        Page<Article> pageInfo = articleService.getArticleByPage(pageRqe);
        sysUserService.getAccInfo(pageInfo);
        return pageInfo;
    }

    /**
     * 文章详情
     */
    @GetMapping("/detail/{articleId}")
    public String queryArticle(@PathVariable String articleId) throws Exception {
        if (ObjectUtil.isNull(articleId)) {
            throw new BizException("文章信息不存在！");
        }
        Article articleInfo = articleService.queryArticle(Long.valueOf(articleId));
        if (ObjectUtil.isNull(articleInfo)) {
            throw new BizException("文章信息不存在！");
        }
        sysUserService.getAccInfo(articleInfo);
        req.setAttribute("currentCategoryId", articleInfo.getTypeId()); // 文章分类id
        req.setAttribute("article", articleInfo);
        return "main/article/detail";
    }

    /**
     * 热门文章
     */
    @RequestMapping(value = "/hot", method = RequestMethod.GET)
    @ResponseBody
    public Page<Article> getHotArticles(int page) throws Exception {
        Sort sort = new Sort(Sort.Direction.DESC, "viewCount");
        PageRequest pageReq = PageRequest.of(page, 20, sort);
        Page<Article> pageInfo = articleService.getArticleByPage(pageReq);
        sysUserService.getAccInfo(pageInfo);
        return pageInfo;
    }
}