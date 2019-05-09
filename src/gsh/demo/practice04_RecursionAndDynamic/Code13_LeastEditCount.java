package gsh.demo.practice04_RecursionAndDynamic;

/**
 * 最小编辑代价
 * <p>
 * 给定两个字符串 和 3个整数 ic dc rc  插入删除替换
 * <p>
 * 求替换的最小代价
 */

public class Code13_LeastEditCount {

    public int leastEditCost(String str1, String str2, int ic, int dc, int rc) {

        if (str1 == null || str2 == null) {
            return 0;
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int[][] dp = new int[arr1.length + 1][arr2.length + 1];

        for (int i = 0; i < arr1.length + 1; i++) {
            dp[0][i] = i * ic;
        }

        for (int i = 0; i < arr2.length + 1; i++) {
            dp[i][0] = i * dc;
        }

        /**
         *
         * dp[i,j] 有四种情况
         *
         */
        for (int i = 1; i < arr1.length + 1; i++) {
            for (int j = 1; j < arr2.length + 1; j++) {
                int dp1 = dp[i - 1][j] - dc;
                int dp2 = dp[i][j - 1] + ic;
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.max(Math.max(dp1, dp2), dp[i][j]);
            }
        }

        return dp[arr1.length][arr2.length];


    }


}
