package cn.amarone.model.sys.user.service;

import org.springframework.data.domain.Page;

import cn.amarone.model.common.exception.BizException;
import cn.amarone.model.sys.article.entity.Article;
import cn.amarone.model.sys.user.entity.SysUser;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年03月26日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
public interface ISysUserService {


    /**
     * 校验用户信息
     *
     * @param userInfo 用户信息
     * @return Returns true if it exists
     * @description loginName must be not null<br/> passwd 必须得是密文
     */
    SysUser verifyAcc(SysUser userInfo) throws BizException;

    /**
     * 根据用户id获取用户信息
     */
    SysUser getAccInfo(Long userId) throws BizException;


    void getAccInfo(Page<Article> pageInfo) throws BizException;
}
