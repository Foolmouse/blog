package com.hanslaser.blog.entity;

import com.hanslaser.blog.entity.vo.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 博客文章实体类
 *
 * @author LuoJu
 * @since 2018.10.31
 */
@Entity
@Table(name = "blog")
public class Blog extends BaseModel {

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String writer;

    @Column
    private Integer category;

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}