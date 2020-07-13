package com.hanslaser.blog.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 两个数组的交集II {
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> mapOne = new HashMap<>();
        HashMap<Integer, Integer> mapTwo = new HashMap<>();
        for (int i : nums1) {
            mapOne.put(i, mapOne.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            mapTwo.put(i, mapTwo.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (Integer key : mapOne.keySet()) {
            if (mapTwo.get(key) == null) {
                continue;
            }else{
                for (int j = 0; j < Math.min(mapOne.get(key), mapTwo.get(key)); j++) {
                    list.add(key);
                }
            }
        }

        int[] ints = new int[list.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] one = {1, 2, 2, 1};
        int[] two = { 2, 2};
        int[] ints = intersect(one, two);

    }
}
