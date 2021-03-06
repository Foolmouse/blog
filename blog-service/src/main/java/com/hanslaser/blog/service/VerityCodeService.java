package com.hanslaser.blog.service;

import com.hanslaser.blog.entity.vo.VerityCode;

import javax.mail.MessagingException;

/**
 * description: this's interface of verity code sender  to User;
 *
 * @author LuoJu
 * @since 2018.11.06
 */
public interface VerityCodeService {

    VerityCode sendEmailVerityCode(String prefixMessage, String email) throws MessagingException;

    void subscribeEmail(String visitorEmail) throws MessagingException;

    boolean checkSubscribe(String visitorEmail);
}
