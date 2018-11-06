package com.hanslaser.blog.service;

import com.hanslaser.blog.entity.Blog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author LuoJu
 * @since 2018.11.1
 * Blog Service接口
 */
@Service
public interface BlogService {

    /**
     * 创建Blog
     */
    Blog create(Blog blog);

    List<Blog> findAll();

    Blog update(Blog blog);

    void delete(Long id);

    Blog findById(Long id);
}