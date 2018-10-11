package com.hanslaser.blog.entity.controller;

import com.hanslaser.blog.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LuoJu
 * @since 2018.10.11
 */
@RestController
//@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/login")
    public Result login(@RequestParam String userName, @RequestParam String password) {
        System.out.println(userName + ":::" + password);
        if ("admin".equals(userName) && "admin".equals(password)) {
            return new Result(true, "登录成功");
        }else{
            return new Result(false, "登录失败");
        }
    }

}