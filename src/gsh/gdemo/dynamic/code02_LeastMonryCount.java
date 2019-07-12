package gsh.gdemo.dynamic;

/**
 * 换钱最少的货币
 */


public class code02_LeastMonryCount {

    // 每一张面值都尝试不同的张数

    public int process(int[] arr, int i, int rest) {

        if (i == arr.length) {
            return rest == 0 ? 0 : -1;
        }
        int res = -1;
        for (int k = 0; k * arr[i] < res; k++) {
            int next = process(arr, i + 1, rest - k * arr[i]);
            if (next != -1) {
                res = res == -1 ? k + next : Math.max(k + next, res);
            }
        }
        return res;
    }

    // 可变参数 i 和 rest 组成的的 一个二维表

    // 无后向性 满足 动态规划的条件


    public int dynamic(int[] arr, int aim) {

        // checkinput

        int N = arr.length;
        int[][] dp = new int[N + 1][aim];
        for (int col = 1; col < aim; col++) {
            dp[N][col] = -1;
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int rest = 0; rest < aim; rest++) {
                dp[i][rest] = -1;
                if (dp[i + 1][rest] != -1) {
                    dp[i][rest] = dp[i + 1][rest];
                }
                if (rest - arr[i] >= 0 && dp[i][rest - arr[i]] != -1) {
                    if (dp[i][rest] == -1) {
                        dp[i][rest] = dp[i][rest - arr[i]] + 1;
                    } else {
                        dp[i][rest] = Math.min(dp[i][rest], dp[i][rest - arr[i]] + 1);
                    }
                }
            }
        }


        return dp[0][aim];

    }


}
