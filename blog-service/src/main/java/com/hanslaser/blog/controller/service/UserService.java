package com.hanslaser.blog.controller.service;

import com.hanslaser.blog.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author LuoJu
 * @since 2018.10.11
 * 后台登录接口
 */
@Service
public interface UserService {

    User login(String userName , String password);



}