package com.hanslaser.blog.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LuoJu
 * @since 2018.11.1
 * Blog's repository interface
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {


}