package com.hanslaser.blog.service.impl;

import com.hanslaser.blog.entity.Blog;
import com.hanslaser.blog.entity.BlogRepository;
import com.hanslaser.blog.service.BlogService;
import com.hanslaser.blog.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (!StringUtils.isEmpty(blog.getCover())) {
            blog.setCover(handleCoverPath(blog.getCover()));
        }
        blog.setCreatedDatetime(com.hanslaser.blog.util.DateUtils.getTimestamp());
        blog.setLastModifiedDatetime(com.hanslaser.blog.util.DateUtils.getTimestamp());
        return blogRepository.save(blog);
    }

    /**
     * 处理截取图片展示图路径
     */
    private String handleCoverPath(String cover) {
        String pattern = AttachmentServiceImpl.VIRTUAL_PATH + "(.*?)(\\.(.{3}))";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(cover);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new RuntimeException("路径错误,请检查图片格式或者路径");
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll(Sort.by("lastModifiedDatetime"));
    }

    @Override
    public Page<Blog> findByPage(int currentPage, int pageSize) {
        PageRequest request = new PageRequest(currentPage, pageSize, Sort.Direction.DESC, "lastModifiedDatetime");
        Page<Blog> page = blogRepository.findAll(request);
        return page;
    }

    @Override
    public Blog update(Blog blog) {
        if (!StringUtils.isEmpty(blog.getCover())) {
            blog.setCover(handleCoverPath(blog.getCover()));
        }
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