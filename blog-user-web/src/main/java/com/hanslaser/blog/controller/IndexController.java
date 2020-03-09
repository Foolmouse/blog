package com.hanslaser.blog.controller;

import com.hanslaser.blog.entity.Blog;
import com.hanslaser.blog.entity.Category;
import com.hanslaser.blog.service.BlogService;
import com.hanslaser.blog.service.CategoryService;
import com.hanslaser.blog.service.PortalLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * portal module
 *
 * @author LuoJu
 * @since 2018.11.07
 */
@Controller
public class IndexController {
    private final static String REDIRECT_INDEX = "redirect:/index";

    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PortalLogService logService;

    @RequestMapping("/")
    public String toIndex(HttpServletRequest request) {
        return REDIRECT_INDEX;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, ModelMap map,
                        @RequestParam(required = false, defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        Page<Blog> page = blogService.findByPage(pageNum - 1, pageSize);
        List<Category> categoryList = categoryService.getAll();
        //博客分类
        map.put("categoryList", categoryList);
        //总条数
        map.put("total", page.getTotalElements());
        //每页数量
        map.put("pageSize", pageSize);
        //总页数
        map.put("totalPages", page.getTotalPages());
        //内容
        map.put("blogList", page.getContent());
        //当前页
        map.put("pageNum", pageNum);
        //是否第一页
        map.put("isFirstPage", page.isFirst());
        //是否最后一页
        map.put("isLastPage", page.isLast());
        //请求url
        map.put("action", "index");

        logService.log(request, "index");
        return "index";
    }

    @RequestMapping(value = "/index/{blogId}", method = RequestMethod.GET)
    public String single(HttpServletRequest request, ModelMap map, @PathVariable Long blogId) {
        //博客分类
        map.put("categoryList", categoryService.getAll());

        //todo 这里从缓存中读取entity没有id？
        Blog blog = blogService.findById(blogId);
        blog.setHits(blog.getHits() + 1);
        blog.setId(blogId);
        blogService.update(blog);

        logService.log(request, blog.getTitle());
        map.put("blog", blog);
        return "single";
    }

    @RequestMapping(value = "/index/like/{blogId}", method = RequestMethod.GET)
    public String like(HttpServletRequest request, ModelMap map, @PathVariable Long blogId) {
        Blog blog = blogService.findById(blogId);
        blog.setLikes(blog.getLikes() + 1);
        blog.setId(blogId);
        blogService.update(blog);
        map.put("blog", blog);
        return "single";
    }

    @RequestMapping(value = "/index/single", method = RequestMethod.GET)
    public String single() {
        return "single";
    }

}










