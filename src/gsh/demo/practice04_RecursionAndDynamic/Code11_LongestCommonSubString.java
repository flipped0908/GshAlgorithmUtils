package gsh.demo.practice04_RecursionAndDynamic;

/**
 * 最长公共子串问题
 * <p>
 * 要求 ：连个字符串的长度为 M N  时间复杂度为O(M*N) 额外空间复杂度为 O(1)
 */
public class Code11_LongestCommonSubString {


    /**
     * 二维的动态规划表
     * dp[i][0]  str1 的第一个字符 与 str2 对比
     * dp[0][j]  str2 的第一个字符 与 str1 对比
     * <p>
     * dp[i][j] 的来源分为1种
     * 状态转移
     * dp[i][j] = dp[i-1][j-1] + str1[i] == str2[j] ?1:0
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
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        // 返回dp中的最大值
        return 0;

    }


    /**
     * dp的额外空间复杂度为 0（M*N）
     */


    public int getres2(String str1, String str2) {
        // TODO inputcheck ...
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int row = 0;
        int col = arr2.length - 1;
        int end = 0;
        int max = 0;
        while (row < arr1.length) {
            int i = row;
            int j = col;
            int len = 0;
            while (i < arr1.length && j < arr2.length) {
                if (arr1[i] == arr2[j]) {
                    len++;
                } else {
                    len = 0;
                }
                if (len > max) {
                    max = len;
                    end = i;
                }
                i++;
                j++;
            }
            if (col > 0) {
                col--;
            } else {
                row++;
            }
        }

        // 根据 end 和 max 计算出 string
        return 0;
    }


}
