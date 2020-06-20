package com.hanslaser.blog.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二叉树的层次遍历II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> table = new ArrayList(10);
        int dept = dept(root, 0, table);
        //倒序一下，顺序：下层 -> 上层
        List<List<Integer>> result = new ArrayList();
        for (int i = table.size() - 1; i >= 0; i--) {
            result.add(table.get(i));
        }
        return result;
    }

    /**
     * 从上层开始，第一层是0，每层递归深度就+1，深度==下标
     *
     * @param root
     * @param dept 树深度
     * @param table
     * @return
     */
    public int dept(TreeNode root, int dept, List<List<Integer>> table) {
        if (root == null) {
            return 0;
        }
        dept++;
        List<Integer> nodes;
        if (table.size() < dept) {
            nodes = new ArrayList<Integer>();
            table.add(nodes);
        } else {
            nodes = table.get(dept - 1);
        }
        nodes.add(root.val);
        //递归
        dept(root.left, dept, table);
        dept(root.right, dept, table);
        return 0;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 测试用例
     */
    public void test() {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        List<List<Integer>> lists = levelOrderBottom(node);

        for (int i = 0; i < lists.size(); i++) {
            List<Integer> nodes = lists.get(i);
            for (Integer integer : nodes) {
                System.out.print(integer + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        二叉树的层次遍历II bean = new 二叉树的层次遍历II();
        bean.test();
    }
}
