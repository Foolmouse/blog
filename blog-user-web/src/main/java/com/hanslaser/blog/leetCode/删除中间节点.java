package com.hanslaser.blog.leetCode;

/**
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：单向链表a->b->c->d->e->f中的节点c 结果：不返回任何数据，但该链表变为a->b->d->e->f
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/delete-middle-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 删除中间节点 {

    /**
     * 表面上是删除当前节点，可是单向链表无法做到 那就让自己成为下一个节点，再跳过下一个节点
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
