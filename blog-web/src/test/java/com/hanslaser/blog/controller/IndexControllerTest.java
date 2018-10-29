package com.hanslaser.blog.controller;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author LuoJu
 * @since 2018.10.10
 */
public class IndexControllerTest {
    @Test
    public void testSayHello() {
        TestCase.assertEquals("Hello,World!", new IndexController().hello());
        Long x = 11111l;
        Long y = 11111l;
        System.out.println( x.equals(y));

    }
}