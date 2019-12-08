package com.hanslaser.blog.lc;

import javax.sound.midi.Soundbank;

public class 合并两个有序链表 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode b = new ListNode(1);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(5);

        a.next=listNode2;
        a.next.next=listNode3;
        b.next=listNode5;
        b.next.next=listNode6;


        合并两个有序链表 thisClass = new 合并两个有序链表();
        ListNode listNode = thisClass.mergeTwoLists(a, b);


    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }


/*    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode returnList = l1.val >= l2.val ? l2 : l1;
        returnList.next=null;
        while (l1 != null && l2 != null) {
            if (l1 == null) {
                while (l2 != null) {
                    pendingLastNode(l2, returnList);
                    l2 = l2.next;
                }
                break;
            }
            if (l2 == null) {
                while (l1 != null) {
                    pendingLastNode(l2, returnList);
                    l1 = l1.next;
                }
                break;
            }

            if (l1.val <= l2.val) {
                pendingLastNode(l2, returnList);
                l1 = l1.next;
            } else {
                pendingLastNode(l2, returnList);
                l2 = l2.next;
            }
        }
        return returnList;

    }*/

    private ListNode pendingLastNode(ListNode l2, ListNode returnList) {
        while (returnList.next != null) {
            returnList=returnList.next;
        }
        returnList.next=l2;

        return returnList;
    }
}
