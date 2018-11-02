package com.hanslaser.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LuoJu
 * @since 2018.10.11
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    public String toLogin() {
        return redirectToIndex();
    }

    /**
     * 重定向到/Index访问首页
     * @return
     */
    @RequestMapping("/redirectToIndex")
    public String redirectToIndex() {
        return "redirect:/index";
    }

    /**
     * 对于templates文件夹下的视图,直接返回视图名(必须添加thymeleaf依赖)
     *
     * @return 返回index视图
     */
    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }

}