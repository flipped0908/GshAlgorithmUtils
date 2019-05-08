package gsh.demo.practice04_RecursionAndDynamic;

/**
 * 最长公共子序列
 * <p>
 * 给定两个字符串 返回两个字符串的最长公共子序列
 */
public class Code10_LongestCommonSubsquence {

    /**
     * 二维的动态规划表
     * dp[i][0]  str1 的第一个字符 与 str2 对比
     * dp[0][j]  str2 的第一个字符 与 str1 对比
     * <p>
     * dp[i][j] 的来源分为3种
     * 状态转移
     * 1 dp[i][j] = dp[i-1][j]
     * 2 dp[i][j] = dp[i][j-1]
     * 3 dp[i][j] = dp[i-1][j-1] + str1[i] == str2[j] ?1:0
     */

    public int getres(String str1, String str2) {
        // TODO inputcheck ...

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int[][] dp = new int[arr1.length][arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            dp[i][0] = arr1[i] == arr2[0] ? 1 : 0;
        }

        for (int i = 0; i < arr2.length; i++) {
            dp[0][i] = arr1[i] == arr1[0] ? 1 : 0;
        }

        for (int i = 1; i < arr1.length - 1; i++) {
            for (int j = 1; j < arr2.length - 1; j++) {
                int add = 0;
                if (arr1[i] == arr2[j]) {
                    add = 1;
                }
                dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1] + add);
            }
        }

        return dp[arr1.length - 1][arr2.length - 1];

    }


}
