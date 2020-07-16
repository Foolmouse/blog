package com.hanslaser.blog.leetCode;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 路径总和 {

    public static boolean hasPathSum(TreeNode node, int sum) {
        if (null == node) {
            return false;
        }
        //如果是叶子节点 && val == sum
        if (node.left == null && node.right == null) {
            return node.val == sum;
        }

        //递归将 sum 每层传下去,如果叶子节点==val 就成立
        return hasPathSum(node.left, sum - node.val) || hasPathSum(node.right, sum - node.val);
    }

    //不正常做法...
    public static int hasPathSum(TreeNode node, int sum, int target) {
        if (null == node) {
            return 0;
        }

        //从上层递归到下层
        //麻蛋,怎么跳出去
        //这里很麻瓜,直接抛出了异常
        if (sum + node.val == target && node.left == null && node.right == null) {
            throw new RuntimeException();
        }
        hasPathSum(node.left, sum + node.val, target);
        hasPathSum(node.right, sum + node.val, target);

        return node.val;
    }



    /**
     *     1
     *   2   3
     *  4   5
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(5);
        hasPathSum(treeNode, 9);
    }


}
