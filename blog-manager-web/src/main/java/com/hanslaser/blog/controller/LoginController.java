package com.hanslaser.blog.controller;

import com.hanslaser.blog.entity.vo.Result;
import com.hanslaser.blog.entity.vo.VerityCode;
import com.hanslaser.blog.service.UserService;
import com.hanslaser.blog.service.VerityCodeService;
import com.hanslaser.blog.util.MyMailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

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
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

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
        try {
            userService.assertEmailExist(email);
            VerityCode verityCode = verityCodeService.sendEmailVerityCode("你的重置密码验证码为:", email);
            session.setAttribute("email", email);
            session.setAttribute("verityCode", verityCode.getVerifyCode());
            logger.info("邮件发送成功 , 验证码为" + verityCode.getVerifyCode());
        } catch (Exception e) {
            logger.info(e.getMessage());
            //e.printStackTrace();
            return new Result(false, e.getMessage());
        }
        return new Result(true, "");
    }

    /**
     * 重置密码
     */
    @ResponseBody
    @RequestMapping("/resetUserPassword")
    public Result resetUserPassword(@RequestParam String verifyCode, @RequestParam String newPassword, @RequestParam String confirmPassword) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String email = (String) request.getSession().getAttribute("email");
        String localVerityCode = (String) request.getSession().getAttribute("verityCode");

        if (null != email) {
            if (!newPassword.equals(confirmPassword)) {
                return new Result(false, "两次输入密码不一致");
            }
            if (!localVerityCode.equals(verifyCode)) {
                return new Result(false, "验证码不正确");
            }
            userService.updatePasswordByEmail(passwordEncoder.encode(newPassword), email);
            return new Result(true, "");
        } else {
            return new Result(false, "验证已失效,请重新发送验证码");
        }
    }

}