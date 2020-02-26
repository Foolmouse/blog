package com.hanslaser.blog.leetCode;

public class 颠倒二进制数字 {


    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev = 0;

        while (n > 10) {
            int last = n % 10;
            rev = last * 10 + last;
        }


        return 0;
    }


    public static void main(String[] args) {
        System.out.println(reverseBits2(123));
    }


    public static int reverseBits2(int n) {

        int i = 0;
        while (n != 0) {
            if (i >= Integer.MAX_VALUE / 10 || i <= Integer.MIN_VALUE / 10) {
                return 0;
            }

            int last = n % 10;

            i = i * 10 + last;

            n = n / 10;
        }

        return 0;
    }

}
