/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.sys.sysConfig.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.amarone.model.sys.sysConfig.entity.SysConfig;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年04月19日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
public interface ISysConfigDao extends JpaRepository<SysConfig, Long> {

}
