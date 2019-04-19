/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.sys.main.controller;

import com.google.code.kaptcha.Producer;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import cn.amarone.model.article.controller.ArticlesController;
import cn.amarone.model.article.entity.Article;
import cn.amarone.model.sys.common.BaseController;
import cn.amarone.model.sys.common.BizConst.CommonConst;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年03月27日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
@Slf4j
@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

    @Autowired
    private Producer producer;

    @Autowired
    private ArticlesController articlesController;

    /**
     * 获取文章
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getArticles() throws Exception {
        // 热门文章
        Page<Article> pageInfo = articlesController.getTopArticles(0);
        req.setAttribute("topArticles", pageInfo);
        // 综合文章
        Page<Article> synthesizeArticles = articlesController.getSynthesizeArticles(0);
        req.setAttribute("synthesizeArticles", synthesizeArticles);
        return "index";
    }

    @GetMapping("/capthca.jpg")
    public void captcha(HttpServletResponse response) throws IOException {
        // 不缓存此内容
        response.setHeader("Cache-Control", "no-store, no-cache");
        // 设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //把验证码存到shrio的session中
        SecurityUtils.getSubject().getSession().setAttribute(CommonConst.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream outputStream = response.getOutputStream();
        // 将内存中的图片通过流动形式输出到客户端
        ImageIO.write(image, "jpg", outputStream);
    }
}