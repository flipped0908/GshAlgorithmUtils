package gsh.demo.practice04_RecursionAndDynamic;


/**
 * 还钱对少的货币
 * 给定数组 arr  arr中所有的数组都是正数 不重复，每一个值代表一种面值的货币
 * 给定一个数 aim 求组成 aim  求还钱有多少种方法
 */
public class Code05_changeMoneyCount {


    // 递归 version1 1.0

    public static int process(int[] arr, int rest) {

        if (rest == 0) {
            return 1;
        }
        if (rest < 0) {
            return 0;
        }

        int res = 0;

        for (int i = 0; i < arr.length; i++) {

            rest = rest - arr[i];
            res += process(arr, rest);

        }

        return res;


    }


    // 递归 version 2.0
    // 在1.0中 返回的结果 并没有记录下来 还是在原来的栈中

    public static int precess2(int[] arr, int index, int rest) {
        int res = 0;

        //basecase

        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        for (int i = 0; arr[index] * i <= rest; i++) {
            res += precess2(arr, index + 1, rest - arr[index] * i);
        }
        return res;

    }


    /**
     * 添加map 进行记忆搜索  version 3.0
     */


    public static int precess3(int[] arr, int index, int rest, int[][] map) {
        int res = 0;

        //basecase

        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        for (int i = 0; arr[index] * i <= rest; i++) {
            if (map[index + 1][res - arr[index] * i] != -1) {
                res += map[index + 1][res - arr[index] * i];
            } else {
                res += precess3(arr, index + 1, rest - arr[index] * i, map);
            }
        }
        map[index][rest] = res == 0 ? -1 : res;

        return res;

    }

    /**
     * 动态规划  version 4.0
     */
    public static int getCntDy(int[] arr, int aim) {
        if (arr == null) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; arr[0] * i <= aim; i++) {
            dp[0][arr[0] * i] = 1;
        }
        int num = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                num = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    num += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length - 1][aim];
    }


    public static void main(String[] args) {

        int[] arr = {2, 5};
        System.out.println(process(arr, 10));

    }


}
