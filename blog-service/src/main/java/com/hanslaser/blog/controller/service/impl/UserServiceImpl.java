package com.hanslaser.blog.controller.service.impl;

import com.hanslaser.blog.controller.service.UserService;
import com.hanslaser.blog.entity.User;
import com.hanslaser.blog.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return userRepository.findByUsernameAndPassword(userName.toLowerCase(), password);
    }
}