package com.hanslaser.blog.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author LuoJu
 * @since 2018.11.14
 */
@Entity
@Table
public class PortalLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private String blogName;

    /**
     * ip
     */
    @Column(length = 64)
    private String ip;

    /**
     * 浏览器信息
     */
    @Column(length = 512)
    private String userAgent;

    /**
     * 请求方式
     */
    @Column
    private String method;

    /**
     * 访问时间
     */
    @Column
    private Timestamp requestDateTime;

    /**
     * 错误信息
     */
    @Column(length = 512)
    private String errorMessage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Timestamp getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(Timestamp requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public void setErrorMessage(String errorMessage) {

        this.errorMessage = errorMessage;
    }
}