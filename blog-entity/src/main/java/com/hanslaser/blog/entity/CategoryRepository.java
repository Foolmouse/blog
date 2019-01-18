package com.hanslaser.blog.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author LuoJu
 * @since 2018.01.16
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /**
     * 根据num查询分类
     *
     * @param num
     * @return
     */
    @Query("select c from Category c where c.num=?1")
    Category findByNum(int num);

}