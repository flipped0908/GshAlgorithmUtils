package gsh.demo.practice04_RecursionAndDynamic;

/**
 * 矩阵最小路径和
 * 给定一个矩阵m 从左上角开始每次只能向右或者向下走，达到最右下角的位置
 * 路径上所有的数字累加起来的和
 * 返回所有路径中最小的和
 */
public class Code02_matrixMinPathSum {


    public static int getLeastShotPath(int[][] m) {

        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }

        int row = m.length;
        int col = m[0].length;

        int[][] dp = new int[row][col];

        dp[0][0] = m[0][0];

        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + m[0][i];
        }

        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + m[i][j];
            }
        }

        return dp[row - 1][col - 1];

    }


    public static void main(String[] args) {

        int[][] m = {{1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}};

        System.out.println(getLeastShotPath(m));

    }


}
