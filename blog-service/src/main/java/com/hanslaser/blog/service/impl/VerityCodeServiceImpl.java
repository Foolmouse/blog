package com.hanslaser.blog.service.impl;

import com.hanslaser.blog.entity.VisitorEmail;
import com.hanslaser.blog.entity.vo.VerityCode;
import com.hanslaser.blog.service.VerityCodeService;
import com.hanslaser.blog.service.VisitorEmailService;
import com.hanslaser.blog.util.MyMailSender;
import com.hanslaser.blog.util.VerityCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.util.Calendar;
import java.util.Date;

/**
 * @author LuoJu
 * @since 2018.11.06
 */
@Service
@Transactional
public class VerityCodeServiceImpl implements VerityCodeService {

    private static String welcome = "欢迎关注罗炬的个人博客,以后有更新会提示你哦.网站地址www.dunkluo.top,<a href=\"http://dunkluo.top\" target=\"_blank\">点击访问博客~</a>";

    @Autowired
    private MyMailSender myMailSender;

    @Autowired
    private VisitorEmailService visitorEmailService;

    @Override
    public VerityCode sendEmailVerityCode(String prefixMessage, String email) throws MessagingException {
        VerityCode code = new VerityCode();
        code.setEmail(email);
        Date sendDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sendDate);
        calendar.add(Calendar.MINUTE, 30);
        code.setExpiredDatetime(calendar.getTime());
        code.setVerifyCode(VerityCodeUtil.generationVerityCode(4));

        myMailSender.sendMail(email, "重置密码验证码", prefixMessage + code.getVerifyCode());
        //todo
        //目前使用量小,后期验证码放入redis缓存中
        return code;
    }

    @Override
    public void subscribeEmail(String visitorEmail) throws MessagingException {
        VisitorEmail email = new VisitorEmail();
        email.setVisitorEmail(visitorEmail);
        try {
            myMailSender.sendMail(visitorEmail, "罗炬的个人博客", welcome);
            email.setEnable("可用,发送正常");
        } catch (MessagingException e) {
            e.printStackTrace();
            email.setEnable(e.toString());
            throw e;
        } finally {
            visitorEmailService.add(email);
        }
    }

    @Override
    public boolean checkSubscribe(String visitorEmail) {
        VisitorEmail byVisitorEmail = visitorEmailService.findByVisitorEmail(visitorEmail);
        return null == byVisitorEmail ? true : false;
    }
}