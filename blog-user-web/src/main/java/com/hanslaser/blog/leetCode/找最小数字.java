package com.hanslaser.blog.leetCode;

import java.util.HashMap;

public class 找最小数字 {

    public static void main(String[] args) {

        int[] ints = {1, 2, 3,4, 5, 14};
        System.out.println(findMinID(ints));
    }


    public static int findMinID(int[] arr) {
        int num = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (i > num) num = i;
            map.put(i, 1);
        }
        for (int i = 1; i < num; i++) {
            if (map.get(i) == null) return i;

        }
        return num++;
    }
}
