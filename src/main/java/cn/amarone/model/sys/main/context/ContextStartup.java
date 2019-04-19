/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.sys.main.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

import cn.amarone.model.sys.sysConfig.service.ISysConfigService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Amarone
 * @Created Date: 2019年04月17日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 * @Description: ApplicationRunner 接口是在容器启动成功后的最后一步回调（类似开机自启动）
 * @see ApplicationRunner
 */
@Slf4j
@Order(1000)
@Component
public class ContextStartup implements ApplicationRunner, ServletContextAware {

    private ServletContext servletContext;

    @Autowired
    private ISysConfigService sysConfigService;

    @Autowired
    private cn.amarone.model.article.service.IArticleTypeService articleTypeService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.servletContext = servletContext;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        // 将所有文章分类放入context上下文
        servletContext.setAttribute("articleType", articleTypeService.getAllType());
        servletContext.setAttribute("config", sysConfigService.getSysConfig());


    }
}