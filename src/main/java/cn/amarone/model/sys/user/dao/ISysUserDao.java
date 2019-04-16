package cn.amarone.model.sys.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.amarone.model.sys.user.entity.SysUser;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年03月26日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
public interface ISysUserDao extends JpaRepository<SysUser, Long> {

    SysUser queryById(Long id);


    SysUser queryByUsername(String username);
}
