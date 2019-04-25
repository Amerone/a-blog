/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.amarone.model.sys.common.BaseController;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年04月24日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @GetMapping("/index")
    public String userIndx() {
        return "main/user/index";
    }

    @GetMapping("/set")
    public String goSet() {
        return "user/set";
    }

    @GetMapping("/message")
    public String goMsg() {
        return "user/message";
    }

    @GetMapping("/home")
    public String goHome() {
        return "user/home";
    }

}