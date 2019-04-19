/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.sys.common;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年03月28日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
public class BaseController {

    @Autowired
    public HttpServletRequest req;
}