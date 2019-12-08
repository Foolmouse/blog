package com.hanslaser.blog.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import sun.security.krb5.internal.crypto.Aes256;
import sun.security.krb5.internal.crypto.Des;
import sun.security.krb5.internal.crypto.Des3;

import java.util.UUID;

public class TestController {


    public static void main(String[] args) {
        String str = "hello world";

//        System.out.println(Aes256.encrypt(str.getBytes(),));
        byte[] bytes = Base64.encodeBase64(str.getBytes());
        System.out.println(Base64.decodeBase64(str.getBytes()));

        System.out.println(UUID.randomUUID());

    }


}
