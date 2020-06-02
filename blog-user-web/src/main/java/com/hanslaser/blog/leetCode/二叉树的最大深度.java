package com.hanslaser.blog.leetCode;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 *          3
 *         / \
 *        9  20
 *          /  \
 *         15   7
 * 返回它的最大深度 3 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class 二叉树的最大深度 {

    /**
     * 递归解法：找出左树和右树的最高节点，每次递归+1
     * 注意：每个节点都要递归左，右树
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        //如果当前节点为null，0层树高
        if (null == root) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        //选出最高的一个节点，加上当前节点
        return Math.max(left,right)+1;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
