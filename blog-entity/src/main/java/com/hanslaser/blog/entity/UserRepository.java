package com.hanslaser.blog.entity;

import org.springframework.data.repository.Repository;

/**
 * @author LuoJu
 * @since 2018.10.24
 */
public interface UserRepository extends Repository<User,Integer> {
    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String userName , String password);


}