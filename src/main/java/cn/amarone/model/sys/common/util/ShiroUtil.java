/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.sys.common.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;

import cn.amarone.model.sys.common.ShiroConfig.SecurityRealm;
import cn.amarone.model.user.entity.SysUser;
import cn.hutool.core.util.ObjectUtil;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年04月24日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
public class ShiroUtil {

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static void logout() {
        getSubject().logout();
    }

    public static SysUser getSysUser() {
        SysUser user = null;
        Object obj = getSubject().getPrincipal();
        if (ObjectUtil.isNotNull(obj)) {
            user = new SysUser();
            BeanUtils.copyProperties(obj, user);
        }
        return user;
    }

    public static void clearCachedAuthorizationInfo() {
        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        SecurityRealm realm = (SecurityRealm) rsm.getRealms().iterator().next();
        realm.clearCachedAuthorizationInfo();
    }
}