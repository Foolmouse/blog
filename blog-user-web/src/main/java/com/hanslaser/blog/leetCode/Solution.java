package com.hanslaser.blog.leetCode;

import java.util.HashMap;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * 移除链表元素
 */
class Solution {

    public static void main(String[] args) {




      /*  LinkedList<Object> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);

        LinkedList<Object> list2 = list1;
        list2.removeLast();
        System.out.println(list1.size());*/

        HashMap<Object, Object> map1 = new HashMap<>();
        map1.put("hhhh", "222");

        HashMap<Object, Object> map2 = new HashMap<>();
        map2.put("map1", map1);

        changeMap(map1);
        System.out.println(map1);

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        removeElements(listNode1, 6);
    }

    public static ListNode removeElements(ListNode head, int val) {
        //删除值相同的头结点后，可能新的头结点也值相等，用循环解决
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null)
            return head;
        ListNode prev = head;
        //确保当前结点后还有结点
        while (prev.next != null) {
            //这里有点不明白，既然prev==head，那他们指向的是同一份对象
            //为什么prev 被等于号指向到了prev.next， 而head的指向确没有变化呢
            //而修改prev的值head却也会跟随变化

            //后续：现在好像看懂了，prev的指向变到了下一个元素到地址，他们指向的不是同一个了
            //什么值拷贝和对象拷贝都是虚的，必须分析指向地址
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static void changeMap(HashMap<Object, Object> map) {
        HashMap map1 = new HashMap<>();
        map1.put("hhhh", 3333);

        map = map1;
    }
}

