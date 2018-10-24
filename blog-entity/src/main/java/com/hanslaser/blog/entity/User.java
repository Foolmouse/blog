package com.hanslaser.blog.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author LuoJu
 * @since 2018.10.11
 */
@Entity
@Table
public class User {
    /**
     * 用户编码.
     */
    @Column(length = 64)
    private String userCode;

    /**
     * 昵称.
     */
    @Column(length = 64)
    private String nickName;

    /**
     * 用户名.
     */
    @Column(length = 64)
    private String userName;

    /**
     * 邮箱可以作为登录账号名.
     */
    @Column(length = 64)
    private String email;

    /**
     * 手机号码可以作为登录账号名.
     */
    @Column(length = 64)
    private String telephone;

    /**
     * 密码.
     */
    @Column(length = 64)
    private String password;

    /**
     * 性别.
     */
    @Column(length = 1)
    private String gender;

    /**
     * 出生日期.
     */
    @Column
    private Date birthDay;

    @Column
    private Boolean isLocked;

    @Column
    private Boolean isExpired;

    /**
     * 头像.
     */
    @Lob
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

    /**
     * 描述.
     */
    @Column(length = 512)
    private String description;
}