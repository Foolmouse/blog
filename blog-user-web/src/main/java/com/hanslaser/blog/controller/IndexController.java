package com.hanslaser.blog.controller;

import com.hanslaser.blog.entity.Blog;
import com.hanslaser.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author LuoJu
 * @since 2018.11.07
 */
@Controller
public class IndexController {
    private final static String REDIRECT_INDEX = "redirect:/index";

    @Autowired
    private BlogService blogService;

    @RequestMapping("/")
    public String toIndex() {
        return REDIRECT_INDEX;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap map) {
        map.put("blogList", blogService.findAll());
        return "index";
    }

    @RequestMapping(value = "/index/{blogId}", method = RequestMethod.GET)
    public String single(ModelMap map, @PathVariable Long blogId) {
        Blog blog = blogService.findById(blogId);
        map.put("blog", blog);
        return "single";
    }

    @RequestMapping(value = "/index/single", method = RequestMethod.GET)
    public String single() {
        return "single";
    }



}










