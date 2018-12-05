package com.hanslaser.blog.service;

import com.hanslaser.blog.entity.User;

/**
 * @author LuoJu
 * @since 2018.10.11
 * 后台登录接口
 */
public interface UserService {

    User login(String userName, String password);

    User findUserByUserNameOrEmail(String userNameOrEmail);

    boolean assertEmailExist(String email);

    void updatePasswordByEmail(String newPassword, String email);

}