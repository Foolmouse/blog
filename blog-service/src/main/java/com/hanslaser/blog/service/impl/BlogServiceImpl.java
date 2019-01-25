package com.hanslaser.blog.service.impl;

import com.hanslaser.blog.entity.Blog;
import com.hanslaser.blog.entity.BlogRepository;
import com.hanslaser.blog.service.BlogService;
import com.hanslaser.blog.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LuoJu
 * @since 2018.11.01
 */
@Service
@CacheConfig(cacheNames = "blogs")
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
        blog.setDr(0);
        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll(Sort.by("lastModifiedDatetime"));
    }

    @Override
    public Page<Blog> findByPage(int currentPage, int pageSize) {
        PageRequest request = PageRequest.of(currentPage, pageSize, Sort.Direction.DESC, "lastModifiedDatetime");
        Blog blog = new Blog();
        blog.setDr(0);
        ExampleMatcher matcher = ExampleMatcher.matching();
        /*
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withMatcher("materialName", GenericPropertyMatchers.contains()) //姓名采用“开始匹配”的方式查询
                .withMatcher("registerTime", GenericPropertyMatchers.contains()) //姓名采用“开始匹配”的方式查询
                .withMatcher("status", GenericPropertyMatchers.contains()) //姓名采用“开始匹配”的方式查询
                .withIgnorePaths("id");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
        */
        //创建实例
        Example<Blog> example = Example.of(blog, matcher);
        Page<Blog> page = blogRepository.findAll(example, request);
        return page;
    }

    @CachePut(key = "#p0.id")
    @Override
    public Blog update(Blog blog) {
        if (!StringUtils.isEmpty(blog.getCover())) {
            blog.setCover(handleCoverPath(blog.getCover()));
        }
        if (blog.getId() == null) {
            System.err.println("Exception: id is null;");
            return null;
        }
        Optional<Blog> oldBlog = blogRepository.findById(blog.getId());
        blog.setCreatedDatetime(oldBlog.get().getCreatedDatetime());
        blog.setLastModifiedDatetime(DateUtils.getTimestamp());
        blog.setDr(0);
        return blogRepository.save(blog);
    }

    @CacheEvict(key = "#p0")
    @Override
    public void delete(Long id) {
        Blog blog = blogRepository.findById(id).get();
        blog.setDr(1);
        blogRepository.save(blog);
    }

    /**
     * 需要注意的是当一个支持缓存的方法在对象内部被调用时是不会触发缓存功能的
     */
    @Cacheable(key = "#p0")
    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public List<Blog> findByCategoryId(Long categoryId) {
        return blogRepository.findByCategory(categoryId);
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
}