package com.hanslaser.blog.entity;

import com.hanslaser.blog.entity.vo.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 博客文章实体类
 *
 * @author LuoJu
 * @since 2018.10.31
 */
@Entity
@Table(name = "blog")
public class Blog extends BaseModel implements Serializable {


    @Column
    private String title;

    @Column
    private String content;

    /**
     * 内容摘要
     */
    @Column
    private String abstractContent;

    @Column
    private String writer;

    @Column
    private Long categoryId;

    /**
     * 封面图片路径
     */
    @Column
    private String cover;



    public String getAbstractContent() {
        return abstractContent;
    }

    public void setAbstractContent(String abstractContent) {
        this.abstractContent = abstractContent;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}