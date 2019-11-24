package com.hanslaser.blog.leetCode;

public class 位1的个数 {

    public static void main(String[] args) {
        //前面加零补齐的是八进制
        hammingWeight(00000000000000000000000000001011);
    }

    public static int hammingWeight(int n) {

        int count = 0;
        int constant = 1;

        //32位数字，循环32次
        for (int i = 0; i < 32; i++) {
            //这里必须不等于0
            //例如  0000000000100 & 4（100）
            //返回二进制100 也就是4
            if ((n & constant)!= 0) {
                count++;
            }
            //等价于 n<<=1 移位加赋值
            constant = constant << 1;

        }
        return count;

    }

//    public static int hammingWeight(int n) {
//
//        char constantOne = '1';
//
//        int count = 0;
//        String binaryString = Integer.toBinaryString(n);
//        for (int i = 0; i < binaryString.length(); i++) {
//            char charAt = binaryString.charAt(i);
//            if (constantOne == charAt) {
//                count ++;
//            }
//        }
//
//        return count;
//    }

}
