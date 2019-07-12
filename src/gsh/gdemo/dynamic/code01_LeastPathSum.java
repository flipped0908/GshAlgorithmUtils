package gsh.gdemo.dynamic;

/***
 *
 * 矩阵 左上到右下的最小路径和
 *
 */

public class code01_LeastPathSum {

    public static int minPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];

        int row = matrix.length;
        int cul = matrix[0].length;

        dp[0][0] = matrix[0][0];

        for (int i = 1; i < row; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }

        for (int i = 1; i < cul; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < cul; i++) {
            for (int j = 1; j < row; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + matrix[i][j], dp[i][j - 1] + matrix[i][j]);
            }
        }

        return dp[cul - 1][row - 1];
    }


}
