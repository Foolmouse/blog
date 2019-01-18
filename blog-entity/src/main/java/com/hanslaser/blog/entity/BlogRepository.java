package com.hanslaser.blog.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LuoJu
 * @since 2018.11.1
 * Blog's repository interface
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    /**
     * 根据博客分类查询博客
     * @param categoryNum
     * @return
     */
    @Query("select b from Blog b where b.dr=0 and b.category=?1")
    List<Blog> findByCategory(int categoryNum);

}