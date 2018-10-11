package com.hanslaser.blog.entity;

import com.hanslaser.blog.entity.controller.HelloWorldController;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author LuoJu
 * @since 2018.10.10
 */
public class HelloWorldControllerTest {
    @Test
    public void testSayHello() {
        TestCase.assertEquals("Hello,World!", new HelloWorldController().hello());
    }
}