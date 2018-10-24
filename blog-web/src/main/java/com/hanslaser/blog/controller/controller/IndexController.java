package com.hanslaser.blog.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.View;

/**
 * @author LuoJu_123855
 * @since 2018.10.10
 */
@Controller
public class IndexController {

    @RequestMapping("/hello")
    public String hello() {
        System.err.println("Hello,World!");
        return "Hello,World!";
    }

    @RequestMapping("/")
    public String index() {
        //重定向配置的后缀没用啊
        return "redirect:index.html";
    }

    @RequestMapping("/index")
    public String toIndex(){
        return index();
    }

}




