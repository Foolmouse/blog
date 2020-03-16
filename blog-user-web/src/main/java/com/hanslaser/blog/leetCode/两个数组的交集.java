package com.hanslaser.blog.leetCode;

import com.sun.corba.se.impl.resolver.ORBDefaultInitRefResolverImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * 通过次数55,786提交次数81,480
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 两个数组的交集 {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashMap<Integer ,Integer> buffMap = new HashMap<Integer ,Integer>();

        for (int i = 0; i < nums1.length; i++) {
            buffMap.put(nums1[i], 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(null != buffMap.get(nums2[i])){
                buffMap.put(nums2[i], 2);
            }
        }

        List<Integer> list = new ArrayList<Integer>();
        for (Integer o : buffMap.keySet()) {
            if (buffMap.get(o) == 2) {
                list.add(o);
            }
        }

        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
           res[i] = list.get(i);

        }
        return res;
    }
}
