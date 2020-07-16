package com.hanslaser.blog.leetCode;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 反转链表 {

    //迭代懒得写了,递归终极解法
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null ) {
            return head;
        }

        ListNode lastNode = reverseList(head.next);
        head.next.next = head;
        //切断循环链表,禁止 1-2-3-2-1
        head.next = null;
        return lastNode;
    }


/**
 * 这是我的垃圾解法..
    public static ListNode reverseList(ListNode head) {
        if(null ==head) return null;

        ListNode index = head;
        while (head.next != null) {
            head = head.next;
        }
        reverse(index);
        return head;
    }

    public static ListNode reverse(ListNode head) {
        if(null ==head) return null;

        if(head.next == null){
            return head;
        }else{
            //从下部开始递归到上部
            ListNode lastNode = reverse(head.next);
            lastNode.next = new ListNode(head.val);
            return lastNode.next;
        }
    }
 */

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        ListNode listNode1 = reverseList(listNode);

        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }

    }


}
