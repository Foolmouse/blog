package com.hanslaser.blog.service;

import com.hanslaser.blog.entity.Blog;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author LuoJu
 * @since 2018.11.1
 * Blog Service接口
 */
public interface BlogService {

    /**
     * 创建Blog
     */
    Blog create(Blog blog);

    /**
     * 查询所有
     */
    List<Blog> findAll();

    /**
     * 分页查询
     */
    Page<Blog> findByPage(int currentPage , int pageSize);

    Blog update(Blog blog);

    void delete(Long id);

    Blog findById(Long id);
}