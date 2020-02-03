package com.hanslaser.blog.leetCode;

import java.util.HashMap;

public class TransferTest {

    public static void main(String[] args) {
        HashMap<Object, Object> map11 = new HashMap<>();
        HashMap map22 = map11;

        map11 = new HashMap<>();
        map11.put("11", "22222");

        System.out.println(map11 + "========" +map22);

        Integer num = 1111111;
        System.out.println("changeNum()方法调用之前：num = " + num);
        changeNum(num);
        System.out.println("changeNum()方法调用之后：num = " + num);
    }

    public static void changeNum(Integer x) {
        x = 22222222;
        System.out.println(x);
    }
}