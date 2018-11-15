package com.hanslaser.blog.service;

import com.hanslaser.blog.entity.LoginLog;

/**
 * @author LuoJu
 * @since 2018.11.1
 * Blog Service接口
 */
public interface LoginLogService {

    /**
     * create login log
     * @param loginLog
     * @return
     */
    LoginLog create(LoginLog loginLog);

}