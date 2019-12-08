package com.hanslaser.blog.leetCode;

import java.time.Year;

public class 颠倒二进制数字 {


    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev = 0;

        while (n > 10) {
            int last = n % 10;
            rev = last*10+last;
        }



        return 0;
    }


    public static void main(String[] args) {
        颠倒二进制数字 xx = new 颠倒二进制数字();
        System.out.println(xx.f());

        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operat(a,b);
        System.out.println(a +":" + b);
    }

    /**
     * x内存地址没变
     * y指向了x，内存地址变了
     * @param x
     * @param y
     */
    static void operat(StringBuffer x, StringBuffer y){
        x.append(y);
        y = x;
    }

    public int f(){
        int i = 0 ;
        try {
            ++i;
        }finally {
            ++i;
        }
        return ++i;
    }


}
