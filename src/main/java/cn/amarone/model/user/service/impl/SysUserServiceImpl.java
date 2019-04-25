package cn.amarone.model.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.amarone.model.sys.common.exception.BizException;
import cn.amarone.model.article.entity.Article;
import cn.amarone.model.user.dao.ISysUserDao;
import cn.amarone.model.user.entity.SysUser;
import cn.amarone.model.user.service.ISysUserService;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年03月26日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private ISysUserDao sysUserDao;


    @Override
    public SysUser verifyAcc(SysUser userInfo) throws BizException {

        if (StrUtil.isEmpty(userInfo.getUsername())) {
            throw new BizException("用户名或密码不存在！");
        }
        SysUser user = sysUserDao.queryByUsername(userInfo.getUsername());
        if (user == null) {
            throw new BizException("用户名或密码不存在！");
        }
        return user;
    }


    @Override
    public SysUser getAccInfo(Long userId) throws BizException {
        if (StrUtil.isEmpty(Long.toString(userId))) {
            throw new BizException("查询用户信息，用户id不可为空！");
        }
        SysUser userInfo = sysUserDao.queryById(userId);

        if (ObjectUtil.isNull(userInfo)) {
            throw new BizException("用户信息不存在！");
        }

        // 校验用户状态


        return userInfo;
    }

    @Override
    public void getAccInfo(Article articleInfo) throws BizException {
        SysUser userInfo = sysUserDao.queryById(articleInfo.getUserId());
        if (userInfo != null) {
            articleInfo.setUserName(userInfo.getUsername());
            articleInfo.setAvatar(userInfo.getAvatar());
        }
    }

    @Override
    public void getAccInfo(Page<Article> pageInfo) throws BizException {
        List<Article> content = pageInfo.getContent();
        if(content!=null && content.size() > 0){
            content.forEach(arts -> {
                SysUser userInfo = sysUserDao.queryById(arts.getUserId());
                if (userInfo != null) {
                    arts.setUserName(userInfo.getUsername());
                    arts.setAvatar(userInfo.getAvatar());
                }
            });
        }
    }
}