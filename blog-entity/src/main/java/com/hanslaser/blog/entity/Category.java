package com.hanslaser.blog.entity;

import com.hanslaser.blog.entity.vo.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * desc : blog's category entity object;
 * @author LuoJu
 * @since 2019.01.16
 */
@Entity
@Table(name = "category")
public class Category extends BaseModel {
    /**
     * category name
     */
    @Column
    private String name;

    /**
     * mapping on DB of column
     */
    @Column
    private Integer num;

    /**
     * total of the kind category for blog
     * @return
     */
    @Transient
    private Integer totalNum;

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}