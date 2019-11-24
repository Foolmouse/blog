package com.hanslaser.blog.leetCode;

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

}
