package com.hanslaser.blog.controller;

import com.hanslaser.blog.util.MailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * @author LuoJu
 * @since 2018.10.11
 */
@Controller
public class LoginController {

    @Autowired
    private MailUtil mailUtil;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/")
    public String toLogin() {
        return redirectToIndex();
    }

    /**
     * 重定向到/Index访问首页
     *
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

    /**
     * 忘记密码,发送邮箱验证码
     */
    @RequestMapping("/forgetPassword/{email}")
    public String forgetPassword(@PathVariable String email, HttpSession session) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            builder.append(random.nextInt() + "");
        }

        try {
            mailUtil.sendMail("luoj123855@hanslaser.com", "验证码", builder.toString());
            HashMap<Object, Object> map = new HashMap();
            map.put("verityCode", builder.toString());
            map.put("verityTime", new Date());
            session.setAttribute("verity", map);
        } catch (MessagingException e) {
            logger.info("邮件发送失败");
            e.printStackTrace();
        }
        return "modifyPassword.html";
    }

    /**
     * 忘记密码,通过邮箱验证码重置
     */
    @RequestMapping("/verityCode")
    public String verityCode(@PathVariable String emailVerityCode) {
        return "";
    }

}