package com.hanslaser.blog.entity.vo;

import java.util.Date;

/**
 * @author LuoJu
 * @since 2018.10.25
 */
public class VerityCode {

    /**
     * 验证码类型
     */
    private String verifyCodeType;

    /**
     * 验证码
     */
    private String verifyCode;

    /**
     * 失效日期
     */
    private Date expiredDatetime;

    /**
     * 描述
     */
    private String description;

    /**
     * 邮箱
     */
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerifyCodeType() {
        return verifyCodeType;
    }

    public void setVerifyCodeType(String verifyCodeType) {
        this.verifyCodeType = verifyCodeType;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Date getExpiredDatetime() {
        return expiredDatetime;
    }

    public void setExpiredDatetime(Date expiredDatetime) {
        this.expiredDatetime = expiredDatetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
