package com.hanslaser.blog.leetCode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 合并两个有序链表 {


    public static void main(String[] args) {
        mergeTwoLists(new ListNode(1), new ListNode(2));
    }

    /**
     * 首先弄清楚了一个很重要的问题
     * returnList / firstList 是
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        }

        ListNode returnList = new ListNode(0);
        ListNode firstList = returnList;

        while (true) {

            if (l1.val > l2.val) {
                returnList.next = l2;
                l2 = l2.next;
            } else {
                returnList.next = l1;
                l1 = l1.next;
            }
            returnList = returnList.next;

            if (l1 == null) {
                returnList.next = l2;
                break;
            }
            if (l2 == null) {
                returnList.next = l1;
                break;
            }
        }
        return firstList.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
