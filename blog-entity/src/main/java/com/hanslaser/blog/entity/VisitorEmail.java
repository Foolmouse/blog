package com.hanslaser.blog.entity;

import com.hanslaser.blog.entity.vo.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * visitor of subscribe email;
 *
 * @author LuoJu
 * @since 2019.02.14
 */
@Entity
@Table(name = "visitor_email")
public class VisitorEmail extends BaseModel {

    @Column
    private String visitorEmail;

    /**
     * 邮箱是否可用,不可以时标记原因
     */
    @Column
    private String enable;

    public String getVisitorEmail() {
        return visitorEmail;
    }

    public void setVisitorEmail(String visitorEmail) {
        this.visitorEmail = visitorEmail;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }
}