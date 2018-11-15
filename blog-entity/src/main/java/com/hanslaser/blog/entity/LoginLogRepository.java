package com.hanslaser.blog.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 后台登录日志
 *
 * @author LuoJu
 * @since 2018.10.24
 */
public interface LoginLogRepository extends JpaRepository<LoginLog, Integer> {

}