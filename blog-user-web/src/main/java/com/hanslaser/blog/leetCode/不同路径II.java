package com.hanslaser.blog.leetCode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 不同路径II {

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[3][];
        obstacleGrid[0] = new  int[]{0,1,0};
        obstacleGrid[1] = new  int[]{0,1,0};
        obstacleGrid[2] = new  int[]{0,0,0};
        int i = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);
    }

    /**
     * 动态规划，拆分问题
     * core： d[n][m] = d[n-1][m] + d[n][m-1]
     * 因为只能向右或者向下，最后最后一格的路径数等于左边和右边格子的相加
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        //用一个二位数组来表示可能性
        //每个位置上的数值=路径数
        int[][] dp = new int[n][m];

        //初始化，最左列和最右列，如果没有遇到障碍，只存在一种可能
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[n - 1][m - 1];
    }




}
