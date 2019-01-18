package com.hanslaser.blog.service.impl;

import com.hanslaser.blog.entity.Blog;
import com.hanslaser.blog.entity.BlogRepository;
import com.hanslaser.blog.service.BlogService;
import com.hanslaser.blog.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.thymeleaf.expression.Lists;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    @Override
    public List<Blog> findByCategoryNum(int categoryNum) {
        return blogRepository.findByCategory(categoryNum);
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