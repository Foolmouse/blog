package com.hanslaser.blog.controller.controller;

import com.hanslaser.blog.controller.service.UserService;
import com.hanslaser.blog.entity.Result;
import com.hanslaser.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LuoJu
 * @since 2018.10.11
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestParam String userName, @RequestParam String password) {
        System.out.println(userName + ":::" + password);
        User user = userService.login(userName, password);
        if (null != user) {
            System.out.println("login successful");
        } else {
            System.out.println("login fail");
        }

        if ("admin".equals(userName) && "admin".equals(password)) {
            return new Result(true, "/views/index.html");
        } else {
            return new Result(false, "登录失败");
        }
    }

    @RequestMapping("/")
    public String toLogin() {
        return "redirect:login.html";
    }

}