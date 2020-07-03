package com.hanslaser.blog.leetCode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class 两数相加 {

    public static void main(String[] args) {
        ListNode node = new ListNode(9);

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(9);
        node1.next.next = new ListNode(9);
        node1.next.next.next = new ListNode(9);
        node1.next.next.next.next = new ListNode(9);


        ListNode listNode = addTwoNumbers(node, node1);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 将两个链表的每个节点相加,如果节点为 null 就略过视作 0
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode toolNode = listNode;

        //是否>=10向上+1
        int isAdd = 0;
        while (l1 != null || l2 != null) {

            int calc = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + isAdd;
            ListNode node;
            if (calc >= 10) {
                isAdd = 1;
                node = new ListNode(calc % 10);
            } else {
                node = new ListNode(calc);
                isAdd = 0;
            }
            if(l1 != null){
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            toolNode.next = node;
            toolNode = node;

        }
        if (isAdd == 1) {
            toolNode.next = new ListNode(1);
        }
        return listNode.next;

    }

    //会丢失精度,当 int 超长
/*    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count = getCountVal(l1) + getCountVal(l2);

        ListNode returnNode = new ListNode(0);
        if (0 == count) {
            return returnNode;
        }
        ListNode calcNode = returnNode;
        while (count != 0) {
            int last = count % 10;
            count = count / 10;

            ListNode node = new ListNode(last);
            calcNode.next = node;
            calcNode = node;
        }
        return returnNode.next;
    }

    private static int getCountVal(ListNode l1) {
        int result_1 = 0;
        int level = 1;
        while (l1 != null) {
            result_1 += l1.val * level;
            level = level * 10;
            l1 = l1.next;
        }
        return result_1;
    }*/

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
