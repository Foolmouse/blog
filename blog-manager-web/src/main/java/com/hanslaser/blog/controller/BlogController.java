package com.hanslaser.blog.controller;

import com.hanslaser.blog.service.BlogService;
import com.hanslaser.blog.entity.Blog;
import com.hanslaser.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 此controller用于处理blog的crud请求,返回视图名因为其他controller不会用到,可通过常量定义在此类中,不需要定义全局变量
 *
 * @author LuoJu
 * @since 2018.10.11
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    private final static String REDIRECT_INDEX = "redirect:/index";
    private final static String REDIRECT_BLOG_LIST = "redirect:/blog/findPage";
    private final static String BLOG_LIST = "blogList";
    private final static String BLOG_FORM = "blogForm";

    @Autowired
    private   BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 获取创建 Blog 表单 , 放入一个无数据对象
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createBlogForm(ModelMap map) {
        map.addAttribute("blog", new Blog());
        map.addAttribute("action", "create");
        map.addAttribute("categoryList", categoryService.getAll());
        return BLOG_FORM;
    }

    /**
     * 创建 Blog
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postBlog(@ModelAttribute Blog blog) {
        blogService.create(blog);
        return REDIRECT_BLOG_LIST;
    }

    /**
     * 更新 Blog
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putBlog(@ModelAttribute Blog blog) {
        blogService.update(blog);
        return REDIRECT_BLOG_LIST;
    }

    /**
     * 删除 Blog
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBlog(@PathVariable Long id, ModelMap map) {
        blogService.delete(id);
        return REDIRECT_BLOG_LIST;
    }

    /**
     * 根据id查询blog , 回显数据
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getBlog(@PathVariable Long id, ModelMap map) {
        Blog blog = blogService.findById(id);
        blog.setId(id);
        map.put("blog", blog);
        map.put("action", "update");
        map.addAttribute("categoryList", categoryService.getAll());
        return BLOG_FORM;
    }

    /**
     * 获取所有blogList
     */
    @RequestMapping(value = "/findPage", method = RequestMethod.GET)
    public String getAllBlog(ModelMap map, @RequestParam(required = false, defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        Page<Blog> page = blogService.findByPage(pageNum - 1, pageSize);
        //总条数
        map.put("total", page.getTotalElements());
        //每页数量
        map.put("pageSize", pageSize);
        //总页数
        map.put("totalPages", page.getTotalPages());
        //内容
        map.put("content", page.getContent());
        //当前页
        map.put("pageNum", pageNum);

        //是否第一页
        map.put("isFirstPage", page.isFirst());
        //是否最后一页
        map.put("isLastPage", page.isLast());
        return BLOG_LIST;
    }

}