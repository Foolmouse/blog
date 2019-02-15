package com.hanslaser.blog.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author LuoJu
 * @since 2019.2.13
 */
public interface VisitorEmailRepository extends JpaRepository<VisitorEmail, Integer> {

    VisitorEmail findByVisitorEmail(String email);

}