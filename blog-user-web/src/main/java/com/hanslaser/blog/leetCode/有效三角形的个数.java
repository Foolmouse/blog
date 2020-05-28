package com.hanslaser.blog.leetCode;

/**
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 *
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 *
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-triangle-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 有效三角形的个数 {

    /**
     * 三层循环
     * 注意，每个元素只能出现一次，因为后面的循环为前面的循环下标+1
     *
     * 有更优解：二分查找？
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                int num2 = nums[j];
                for (int k = j+1; k < nums.length; k++) {
                    int num3 = nums[k];

                    //两条边之和大于第三条，即为三角形
                    if(checkValid(num1,num2,num3)){
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public boolean checkValid(int a,int b ,int c){
        if (a + b > c && b + c > a && a + c > b) {
            System.out.print(a);
            System.out.print(b);
            System.out.print(c);
            System.out.println();
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        有效三角形的个数 x = new 有效三角形的个数();
        int[] arr = new int[]{2, 2, 3, 4};
        x.triangleNumber(arr);


    }
}
