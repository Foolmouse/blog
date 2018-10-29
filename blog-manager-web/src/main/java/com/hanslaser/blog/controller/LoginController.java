package com.hanslaser.blog.controller;

import com.hanslaser.blog.controller.service.UserService;
import com.hanslaser.blog.entity.Result;
import com.hanslaser.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/login")
    @ResponseBody
    public Result login(@RequestParam String userName, @RequestParam String password) {
        System.out.println(userName + ":::" + password);
        User user = userService.login(userName, password);
        if (null != user) {
            System.out.println("login successful");
            return new Result(true, "/views/index.html");
        } else {
            System.out.println("login fail");
            return new Result(false, "登录失败");
        }
    }



    @RequestMapping("/")
    public String toLogin() {
        return "redirect:login.html";
    }

    /**
     * 对于templates文件夹下的视图,直接返回视图名(必须添加thymeleaf依赖)
     * @return
     */
    @RequestMapping("/test")
    public String templateDirTest(){
        return "index";
    }

}