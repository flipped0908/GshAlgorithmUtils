package gsh.demo.practice04_RecursionAndDynamic;

/**
 * 最长递增子序列
 * arr = 2  1  5 3 6 4 8 9 7  返回 1 3 4 8 9
 * O（NlogN） 时间复杂度
 * <p>
 * 是子序列 不是子串
 */
public class Code07_LongestIncrementSubsequence {

    // 方法一 O(N^2)

    // 第i个数 的最大子序列 等于 它前边比它小的任意 位置的子序列 加1

    public int[] getdp1(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp;
    }


    // 方法 2  O(N*Log(N))
    // 在生成dp的时候用 二分查找 优化

    public int[] getdp2(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        int right = 1;
        ends[0] = arr[0];
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int r = getleftmax(arr, right, arr[i]);
            if (r <= right) {
                ends[r] = arr[i];
                dp[i] = dp[i - 1];
            } else {
                right++;
                dp[i] = dp[i - 1] + 1;
            }
        }

        return dp;
    }


    public static int getleftmax(int[] arr, int end, int k) {

        int start = 0;
        int index = 0;
        while (start <= end) {
            index = (end + start) / 2;
            int m = arr[index];
            if (m == k) {
                return index;
            }
            if (m < k) {
                start = index + 1;
            } else {
                end = index - 1;
            }
        }
        return start;
    }


    private static int bs(int[] arr, int hkey) {
        int result = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > hkey) {
                end = mid - 1;
            } else if (arr[mid] < hkey) {
                start = mid + 1;
            } else {
                result = mid;
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 8, 9};

    }


}
