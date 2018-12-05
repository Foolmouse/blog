package com.hanslaser.blog.service.impl;

import com.hanslaser.blog.service.VerityCodeService;
import com.hanslaser.blog.entity.vo.VerityCode;
import com.hanslaser.blog.util.MyMailSender;
import com.hanslaser.blog.util.VerityCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
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

    @Autowired
    private MyMailSender myMailSender;

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

}