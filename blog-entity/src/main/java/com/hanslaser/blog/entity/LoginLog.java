package com.hanslaser.blog.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 后台登录日志
 *
 * @author LuoJu
 * @since 2018.10.31
 */
@Entity
@Table
public class LoginLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * 用户名
     */
    @Column
    private String userName;

    /**
     * 登录状态
     */
    @Column
    private String isLoginSuccess;

    /**
     * ip
     */
    @Column(length = 64)
    private String ip;

    /**
     * 浏览器信息
     */
    @Column(length = 512)
    private String browserInfo;

    /**
     * 请求方式
     */
    @Column
    private String method;

    /**
     * 登录时间
     */
    @Column
    private Timestamp loginDateTime;

    /**
     * 错误信息
     */
    @Column
    private String errorMessage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getBrowserInfo() {
        return browserInfo;
    }

    public void setBrowserInfo(String browserInfo) {
        this.browserInfo = browserInfo;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Timestamp getLoginDateTime() {
        return loginDateTime;
    }

    public void setLoginDateTime(Timestamp loginDateTime) {
        this.loginDateTime = loginDateTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getIsLoginSuccess() {
        return isLoginSuccess;
    }

    public void setIsLoginSuccess(String isLoginSuccess) {
        this.isLoginSuccess = isLoginSuccess;
    }
}