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
    VerityCode sendEmailVerityCode(String email) throws MessagingException;


}
