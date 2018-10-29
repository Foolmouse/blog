package com.hanslaser.blog.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author LuoJu
 * @since 2018.10.11
 */
@Entity
@Table
public class User extends BaseModel {
    /**
     * 用户编码.
     */
    @Column
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
//    @Lob
//    @Basic(fetch = FetchType.EAGER)
//    @Column(name = "image", columnDefinition = "LONGBLOB")
//    private byte[] image;

    /**
     * 描述.
     */
    @Column(length = 512)
    private String description;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    public void setLocked(Boolean locked) {
        isLocked = locked;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public void setExpired(Boolean expired) {
        isExpired = expired;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}