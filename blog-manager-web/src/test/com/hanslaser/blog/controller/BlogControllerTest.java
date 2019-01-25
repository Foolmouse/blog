package com.hanslaser.blog.controller;

import com.hanslaser.blog.WebApplication;
import com.hanslaser.blog.entity.Blog;
import com.hanslaser.blog.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class BlogControllerTest {

    @Autowired
    private BlogService blogService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void getHello() throws Exception {
        Blog byId = blogService.findById(27l);

        Object mystr1 = redisTemplate.opsForValue().get("mystr");
         System.out.println(mystr1);
    }
}

