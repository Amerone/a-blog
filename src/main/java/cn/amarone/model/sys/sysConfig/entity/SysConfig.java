/**
 * Copyright (c) 2019 Amarone- zjlgd.cn , All rights reserved.
 */
package cn.amarone.model.sys.sysConfig.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年04月19日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
@Data
@Entity
@Table(name = "sys_config")
public class SysConfig implements Serializable {

    @Id
    private Long id;

    @Column(name = "title_logo")
    private String titleLogo;

    @Column(name = "copyright")
    private String copyright;

    public SysConfig() {
    }
}