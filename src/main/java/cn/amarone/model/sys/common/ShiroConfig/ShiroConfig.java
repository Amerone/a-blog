/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.sys.common.ShiroConfig;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年03月28日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
@Slf4j
@Configuration
public class ShiroConfig {

    @Bean("securityManager")
    public SecurityManager securityManager(SecurityRealm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);

        log.debug("------------->securityManager注入完成");
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager) {

        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        // 配置登录的url和登录成功的url
        filterFactoryBean.setLoginUrl("/login");
        filterFactoryBean.setSuccessUrl("/index");
        // 配置未授权跳转页面
        filterFactoryBean.setUnauthorizedUrl("error/404");

        Map<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("/login", "anon");
        hashMap.put("/user*", "user");
        hashMap.put("/user/**", "user");
        filterFactoryBean.setFilterChainDefinitionMap(hashMap);

        return filterFactoryBean;
    }

    //用于thymeleaf模板使用shiro标签
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}