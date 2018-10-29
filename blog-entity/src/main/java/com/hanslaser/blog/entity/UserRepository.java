package com.hanslaser.blog.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author LuoJu
 * @since 2018.10.24
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return
     */
    User findByUserNameAndPassword(String userName, String password);

}