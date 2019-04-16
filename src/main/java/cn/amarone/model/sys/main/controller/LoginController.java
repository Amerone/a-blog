/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.sys.main.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.amarone.model.common.BizConst.CommonConst;
import cn.amarone.model.common.response.CommRsp;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年03月28日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
@Controller
public class LoginController {

    @RequestMapping("/goLogin")
    public String goLogin() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public CommRsp login(String username, String password, String vercode) throws Exception {

        if (StrUtil.isEmpty(username) || StrUtil.isEmpty(password) || StrUtil.isEmpty(vercode)) {
            return CommRsp.error("用户名/密码/验证码不能为空！");
        }
        Object vCode = SecurityUtils.getSubject().getSession().getAttribute(CommonConst.KAPTCHA_SESSION_KEY);

        if (!vCode.equals(vercode)) {
            return CommRsp.error("验证码错误！");
        }

//        //构建
//        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, username.getBytes());
//
//        //加密为16进制表示
//        String encryptHex = aes.encryptHex(password);

        AuthenticationToken token = new UsernamePasswordToken(username, SecureUtil.md5(password));


        try {
            //尝试登陆，将会调用realm的认证方法
            SecurityUtils.getSubject().login(token);
        } catch (AuthenticationException e) {
            if (e instanceof UnknownAccountException) {
                return CommRsp.error("用户不存在");
            } else if (e instanceof LockedAccountException) {
                return CommRsp.error("用户被禁用");
            } else if (e instanceof IncorrectCredentialsException) {
                return CommRsp.error("密码错误");
            } else {
                return CommRsp.error("用户认证失败");
            }
        }

        return CommRsp.success("登录成功");
    }
}