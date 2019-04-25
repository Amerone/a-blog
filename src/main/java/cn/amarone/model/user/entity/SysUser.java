package cn.amarone.model.user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年03月26日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
@Data
@Entity
@Table(name = "sys_user")
@Builder
public class SysUser implements Serializable {

    @Id
    private Long id;

    @Column(length = 255, name = "username", nullable = false)
    private String username;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "email", length = 255, nullable = true)
    private String email;

    @Column(name = "mobile", length = 11, nullable = true)
    private Integer mobile;

    /**
     * 性别
     */
    @Column(name = "gender", length = 1, nullable = true)
    private String gender;

    /**
     * 微信
     */
    @Column(name = "wechat", length = 20, nullable = true)
    private String wechat;

    /**
     * 头像
     */
    @Column(name = "avatar", length = 255, nullable = true)
    private String avatar;

    /**
     * 状态
     */
    @Column(name = "status", length = 1, nullable = true)
    private String status;

    /**
     * 最后登录时间
     */
    @Column(name = "lasted", length = 50, nullable = true)
    private String lasted;

    /**
     * 内容数量
     */
    @Column(name = "postCount", length = 50, nullable = true)
    private String postCount;


    /**
     * 评论数量
     */
    @Column(name = "commentCount", length = 50, nullable = true)
    private String commentCount;

    public SysUser() {
    }

    public SysUser(Long id, String username, String password, String email, Integer mobile, String gender, String wechat, String avatar, String status, String lasted, String postCount, String commentCount) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.wechat = wechat;
        this.avatar = avatar;
        this.status = status;
        this.lasted = lasted;
        this.postCount = postCount;
        this.commentCount = commentCount;
    }
}