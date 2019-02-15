package com.hanslaser.blog.controller;

import com.hanslaser.blog.entity.vo.Result;
import com.hanslaser.blog.service.VerityCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;

/**
 * @author LuoJu
 * @since 2019.02.14
 */
@Controller
public class SubscribeController {

    @Autowired
    private VerityCodeService emailService;

    /**
     * 忘记密码,发送邮箱验证码
     */
    @ResponseBody
    @RequestMapping("/subscribeEmail")
    public Result forgetPassword(@RequestParam String email) {
        if (emailService.checkSubscribe(email)) {
            try {
                emailService.subscribeEmail(email);
                return new Result(true, "关注成功");
            } catch (MessagingException e) {
                e.printStackTrace();
                return new Result(false, "请检查邮箱是否可用");
            }
        }
        return new Result(false, "邮箱已关注");
    }

}