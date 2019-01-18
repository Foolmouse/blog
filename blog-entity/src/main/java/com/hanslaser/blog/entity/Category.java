package com.hanslaser.blog.entity;

import com.hanslaser.blog.entity.vo.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;

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
    private String name;

    /**
     * mapping on DB of column
     */
    private Integer num;

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