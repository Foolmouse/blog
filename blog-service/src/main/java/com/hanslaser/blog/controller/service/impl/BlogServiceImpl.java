package com.hanslaser.blog.controller.service.impl;

import com.hanslaser.blog.controller.service.BlogService;
import com.hanslaser.blog.entity.Blog;
import com.hanslaser.blog.entity.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author LuoJu
 * @since 2018.11.1
 */
@Transactional
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog create(Blog blog) {
       return  blogRepository.save(blog);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog update(Blog blog) {
        if (blog.getId() == null) {
            System.err.println("Exception: id is null;");
            return null;
        }
        return blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        Blog blog = blogRepository.findById(id).get();
        blogRepository.delete(blog);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).get();
    }
}