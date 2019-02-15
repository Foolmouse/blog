package com.hanslaser.blog.service;

import com.hanslaser.blog.entity.VisitorEmail;

/**
 * 邮箱订阅
 *
 * @author LuoJu
 * @since 2019.2.15
 */
public interface VisitorEmailService extends BaseService<VisitorEmail> {

    /**
     * 检查email是否已订阅
     * @param email
     * @return
     */
    VisitorEmail findByVisitorEmail(String email);

}