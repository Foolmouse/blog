package com.hanslaser.blog.service.impl;

import com.hanslaser.blog.entity.User;
import com.hanslaser.blog.entity.UserRepository;
import com.hanslaser.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * @author LuoJu
 * @since 2018.10.24
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public User login(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName.toLowerCase(), password);
    }

    @Override
    public User findUserByUserNameOrEmail(String userNameOrEmail) {
        return userRepository.findByUserNameOrEmail(userNameOrEmail);
    }

    @Override
    public boolean assertEmailExist(String email) throws IllegalArgumentException {
        Assert.notNull(findUserByUserNameOrEmail(email), "email账号不存在");
        return true;
    }

    @Override
    public void updatePasswordByEmail(String newPassword, String email) {
//        User user = userRepository.findByUserNameOrEmail(email);
//        user.setPassword(newPassword);
//        userRepository.updateById(user , user.getId());
        userRepository.updatePasswordByEmail(newPassword , email);
    }
}