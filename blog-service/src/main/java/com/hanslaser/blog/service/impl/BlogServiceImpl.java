package com.hanslaser.blog.service.impl;

import com.hanslaser.blog.entity.Blog;
import com.hanslaser.blog.entity.BlogRepository;
import com.hanslaser.blog.service.BlogService;
import com.hanslaser.blog.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LuoJu
 * @since 2018.11.1
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog create(Blog blog) {
        blog.setCreatedDatetime(DateUtils.getTimestamp());
        return blogRepository.save(blog);
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
        blog.setLastModifiedDatetime(DateUtils.getTimestamp());
        return blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        Blog blog = blogRepository.findById(id).get();
        blog.setDr(1);
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).get();
    }
}