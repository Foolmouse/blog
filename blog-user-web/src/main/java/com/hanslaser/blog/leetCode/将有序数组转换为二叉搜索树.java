package com.hanslaser.blog.leetCode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 将有序数组转换为二叉搜索树 {

    public static void main(String[] args) {
        int[] nums = {-2, -1, 0  ,1, 2};
        sortedArrayToBST(nums);

    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        TreeNode recursive = recursive(null, nums, 0, nums.length - 1);
        System.out.println(recursive);
        return recursive;
    }

    static TreeNode recursive(TreeNode node, int[] nums, int start, int end) {
        //node always is null
        //允许 start == end
        if (start > end) {
            return node;
        }

        //取中位数作为根节点
        int mid = (end + start) / 2;
        node = new TreeNode(nums[mid]);

        //递归左右节点
        node.left = recursive(null, nums, start, mid - 1);
        node.right = recursive(null, nums, mid + 1, end);

        return node;
    }

}
