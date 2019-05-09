package gsh.demo.practice04_RecursionAndDynamic;

/**
 * 给定一个二维数组，是一张地图， 有正负0，根据map返回初始血量
 */
public class Code15_MatrixGame {

    public int minHP(int[][] m) {

        if (m == null) {
            return 0;
        }

        int row = m.length;
        int col = m[0].length;

        int[][] dp = new int[row][col];

        dp[row - 1][col - 1] = m[row - 1][col - 1];

        for (int i = row - 1; i >= 0; i--) {
            int ph = dp[i + 1][col - 1] - m[i][col - 1];
            dp[i][col - 1] = ph < 1 ? 1 : ph;
        }

        for (int i = col - 1; i >= 0; i--) {
            int ph = dp[row - 1][i] - m[row - 1][i + 1];
            dp[row - 1][i] = ph < 1 ? 1 : ph;
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                int up = dp[i + 1][j] - m[i][j];
                int left = dp[i][j + 1] - m[i][j];
                up = up < 1 ? 1 : up;
                left = left < 1 ? 1 : left;
                dp[i][j] = Math.min(up, left);
            }
        }

        return dp[0][0];
    }

}
