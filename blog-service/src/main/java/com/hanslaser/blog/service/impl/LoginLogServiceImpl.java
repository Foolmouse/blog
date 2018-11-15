package com.hanslaser.blog.service.impl;

import com.hanslaser.blog.entity.LoginLog;
import com.hanslaser.blog.entity.LoginLogRepository;
import com.hanslaser.blog.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LuoJu
 * @since 2018.11.1
 */
@Service
@Transactional
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogRepository logRepository;

    @Override
    public LoginLog create(LoginLog loginLog) {
        return logRepository.save(loginLog);
    }
}