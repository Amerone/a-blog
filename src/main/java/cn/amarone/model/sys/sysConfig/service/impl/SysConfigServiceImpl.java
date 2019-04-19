/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.sys.sysConfig.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.amarone.model.sys.sysConfig.dao.ISysConfigDao;
import cn.amarone.model.sys.sysConfig.entity.SysConfig;
import cn.amarone.model.sys.sysConfig.service.ISysConfigService;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年04月19日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
@Service
public class SysConfigServiceImpl implements ISysConfigService {

    @Autowired
    private ISysConfigDao sysConfigDao;

    @Override
    public SysConfig getSysConfig() {
        return sysConfigDao.findAll().get(0);
    }
}