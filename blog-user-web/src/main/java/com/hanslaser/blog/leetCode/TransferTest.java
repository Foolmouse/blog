package com.hanslaser.blog.leetCode;

public class TransferTest {

    public static void main(String[] args) {
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