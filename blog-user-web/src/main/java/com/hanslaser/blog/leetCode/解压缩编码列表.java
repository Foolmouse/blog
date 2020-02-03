package com.hanslaser.blog.leetCode;

import javax.swing.text.StyledEditorKit;

/**
 * 给你一个以行程长度编码压缩的整数列表 nums 。 考虑每对相邻的两个元素 [a, b] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后有
 * a 个值为 b 的元素。 请你返回解压后的列表。 示例：
 * <p>
 * 输入：nums = [1,2,3,4] 输出：[2,4,4,4] 解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。 第二对 [3,4] 代表着 4 的出现频次为
 * 3，所以生成数组 [4,4,4]。 最后将它们串联到一起 [2] + [4,4,4,4] = [2,4,4,4]。   提示： 2 <= nums.length <= 100
 * nums.length % 2 == 0 1 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/decompress-run-length-encoded-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 解压缩编码列表 {


    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4,5,6};
        int[] rlElist = decompressRLElist(ints);
        for (int i = 0; i < rlElist.length; i++) {
            int i1 = rlElist[i];
            System.out.println(i1);
        }
    }

    public static int[] decompressRLElist(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                count += nums[i];
            }
        }

        int[] returnArr = new int[count];
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                returnArr[index] = nums[i+1];
                index++;
            }
        }
        return returnArr;

    }
}
