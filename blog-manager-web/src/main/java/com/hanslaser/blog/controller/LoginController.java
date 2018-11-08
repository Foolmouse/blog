package com.hanslaser.blog.controller;

import com.hanslaser.blog.entity.vo.Result;
import com.hanslaser.blog.entity.vo.VerityCode;
import com.hanslaser.blog.service.VerityCodeService;
import com.hanslaser.blog.util.MyMailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author LuoJu
 * @since 2018.10.11
 */
@Controller
public class LoginController {

    @Autowired
    private MyMailSender myMailSender;

    @Autowired
    private VerityCodeService verityCodeService;

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
    @ResponseBody
    @RequestMapping("/sendEmailWithVerifyCode")
    public Result forgetPassword(@RequestParam String email, HttpSession session) {
        logger.info(">>>>>>>>>>>" + email);
        try {
            VerityCode verityCode = verityCodeService.sendEmailVerityCode(email);
            session.setAttribute(email , verityCode);
            logger.info("邮件发送成功");
        } catch (Exception e) {
            logger.info("邮件发送失败");
            e.printStackTrace();
        }
        return new Result(true, "");
    }

    /**
     * 忘记密码,通过邮箱验证码重置
     */
    @RequestMapping("/verityCode")
    public String verityCode(@PathVariable String emailVerityCode , HttpSession session) {
        return "";
    }

}