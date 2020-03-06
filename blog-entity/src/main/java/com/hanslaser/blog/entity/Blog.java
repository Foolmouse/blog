package com.hanslaser.blog.entity;

import com.hanslaser.blog.entity.vo.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Data;

/**
 * 博客文章实体类
 *
 * @author LuoJu
 * @since 2018.10.31
 */

@Data
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

    /**
     * 点击量
     */
    @Column
    private Integer hits;

    /**
     * 点赞数
     */
    @Column
    private Integer likes;

}