package com.hanslaser.blog.leetCode;


/**
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释: 长度最长的公共子数组是 [3, 2, 1]。
 *
 * 说明:
 * 1 <= len(A), len(B) <= 1000 0 <= A[i], B[i] < 100
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 最长重复子数组 {


    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3};
        int[] b = {2, 3, 3, 4};
        System.out.println(findLength(a, b));
    }


    /**
     * 暴力解超时了,我好菜...
     * @param A
     * @param B
     * @return
     */
    public static int findLength(int[] A, int[] B) {

        int result = 0;

        for (int i = 0; i < A.length; i++) {
            int i1 = A[i];
            if (i1 >= 100) {
                
            }
            for (int j = 0; j < B.length; j++) {
                int i2 = B[j];

                if (i1 == i2) {
                    int count = 1;
                    //index out of bounds
                    while (((i + count) < A.length && (j + count) < B.length) && (A[i + count] == B[j + count])) {
                        count++;
                    }
                    if (result < count) {
                        System.out.println(String.format("result:%d   count:%d", result, count));
                        result = count;
                    }
                }


            }
        }
        return result;
    }


}
