package gsh.demo.practice04_RecursionAndDynamic;

/**
 * 字符串交错成组
 * <p>
 * 给定3个字符串  str1 str2 aim
 * aim中属于str1 和属于str2 的字符之间保持原来的顺序
 */
public class Code14_StringsInterlaceIntoGroups {

    public boolean leastEditCost(String str1, String str2, String aim) {

        if (str1 == null || str2 == null || aim == null) {
            return false;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        char[] aimarr = aim.toCharArray();

        boolean[][] dp = new boolean[arr1.length + 1][arr2.length + 1];
        for (int i = 1; i < arr1.length + 1; i++) {
            if (arr1[i - 1] != aimarr[i - 1]) {
                break;
            }
            dp[i][0] = true;
        }
        for (int i = 1; i < arr2.length + 1; i++) {
            if (arr2[i - 1] != aimarr[i - 1]) {
                break;
            }
            dp[0][i] = true;
        }

        for (int i = 1; i < arr1.length + 1; i++) {
            for (int j = 1; j < arr2.length + 1; j++) {
                if (  (arr1[i - 1] == aimarr[i + j - 1] && dp[i - 1][j])
                        || (arr2[j - 1] == aimarr[i + j - 1] && dp[i][j - 1])  ) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[arr1.length][arr2.length];
    }


}
