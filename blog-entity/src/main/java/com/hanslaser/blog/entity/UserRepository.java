package com.hanslaser.blog.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

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

    /**
     * 根据username或者email查询User
     *
     * @param userNameOrEmail
     * @return
     */
    @Query("select u from User u where u.userName=?1 or u.email=?1")
    User findByUserNameOrEmail(String userNameOrEmail);

    /**
     * 根据邮箱地址更新密码
     *
     * @param newPassword
     * @param email
     */
    @Modifying
    @Query("update User u set u.password = ?1 where u.email = ?2")
    void updatePasswordByEmail(String newPassword, String email);
}