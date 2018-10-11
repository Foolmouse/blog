package com.hanslaser.blog.entity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LuoJu_123855
 * @since 2018.10.10
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String hello() {
        System.err.println("Hello,World!");
        return "Hello,World!";
    }
}




