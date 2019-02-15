package com.hanslaser.blog.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MyMailSender {

    private JavaMailSender mailSender;

    @Autowired
    public MyMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * 必须与application.properties中发件人邮箱一致
     */
//    private static String addresser = "NEOA@hanslaser.com";

    @Value("${email.username:#{null}}")
    private String addresser;

    /**
     * @param to      收件人
     * @param subject 邮件主题
     * @param text    邮件内容
     */
    public void sendMail(String to, String subject, String text) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
        helper.setFrom(addresser);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);
        mailSender.send(message);
    }

}
