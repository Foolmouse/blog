package com.hanslaser.blog.controller;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//评测题目:
//给定一个字符串 s，去除字符串中连续重复三次的字母
//示例1: abbbbccdddde -> abccde
//示例2: aabbbac -> c
public class TestController {

    private volatile int a = 9999;


    private static String removeTriplicate(String s) {

        char a = s.charAt(0);
        char b = s.charAt(1);

        for (int i = 2; i < s.length(); i++) {
            if (a == b && b == s.charAt(i)) {
                s = s.substring(0, i - 2) + s.substring(i, s.length());
            } else {
                a = s.charAt(i - 1);
                b = s.charAt(i);
            }

        }

        return s;
    }

    public static void main(String[] args) {
        URL url;
        StringBuilder sb = new StringBuilder() ;
        String encoding = "utf-8";
        try {

            url = new URL("http://fru0yy.coding-pages.com");
            URLConnection conn = url.openConnection();
            if(conn.getContentEncoding()!=null)
                encoding = conn.getContentEncoding();
            try(InputStream raw = conn.getInputStream()){//自动关闭
                InputStream buffer = new BufferedInputStream(raw);
                Reader reader = new InputStreamReader(buffer,encoding);
                int c;
                while((c=reader.read())!=-1) {
                    sb.append((char)c);
                }
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(sb.toString());

//        response.setCharacterEncoding(encoding);
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println(sb);
//        out.flush();


    }


}
