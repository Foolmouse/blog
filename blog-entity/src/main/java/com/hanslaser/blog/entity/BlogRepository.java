package com.hanslaser.blog.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author LuoJu
 * @since 2018.11.1
 * Blog's repository interface
 */
public interface BlogRepository extends JpaRepository<Blog, Long> {


}