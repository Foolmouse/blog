package com.hanslaser.blog.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 门户访问日志
 *
 * @author LuoJu
 * @since 2018.10.24
 */
public interface PortalLogRepository extends JpaRepository<PortalLog, Integer> {

}