package com.hanslaser.blog.leetCode;

import org.hibernate.sql.OracleJoinFragment;

import java.util.ArrayList;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 和为s的连续正数序列 {

    /**
     * 必须要两个数相加，所以最大值为中位数
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int gapTarget = target / 2 + 1;

        ArrayList<int[]> result = new ArrayList<>();
        for (int start = 1; start <= gapTarget; start++) {
            int sum = 0;
            int end = start;
            while (sum < target) {
                sum += end;
                end++;
            }
            if (sum == target) {
                int[] object =  new int[end - start];
                for (int j = 0; j < object.length; j++) {
                    object[j] = start + j;
                }
                result.add(object);
            }
        }
        return result.toArray(new int[result.size()][]);

    }
}
