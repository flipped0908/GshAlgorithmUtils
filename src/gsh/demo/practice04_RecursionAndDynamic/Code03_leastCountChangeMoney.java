package gsh.demo.practice04_RecursionAndDynamic;

/**
 * 换钱对少的货币
 * 给定数组 arr  arr中所有的数组都是正数 不重复，每一个值代表一种面值的货币
 * 给定一个数 aim 求组成 aim 的最少货币数目
 */
public class Code03_leastCountChangeMoney {

    // [5,2,1] 20
    // 暴力递归

    // version 1.0  wrong

    public static int process(int[] arr, int aim, int min) {

        if (aim < min) {
            return 0;
        }
        for (int i = 0; i < arr.length; i++) {
            if (aim == i) {
                return 1;
            }
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = process(arr, aim - i, min) + 1;
        }
        return res;


    }


    // version 2.0   在1.0 中逻辑混乱 对递归的分析有问题

    // 在version1.0 中没有考虑清楚 递归的递减 条件

    // 要学会 思考 变化的变量 和 不变的变量  ，以及是否后向性 ， 递归的条件 ，递归的方向

    /**
     * 剩余的钱 在 第 arr【i...n】 中的最少值
     * <p>
     * 就是可以变化的参数
     */
    public static int process2(int[] arr, int i, int rest) {
        // basecase
        // 已经没有面值能够考虑了，返回-1 （返回-1的时候怎么处理） ; 如果rest == 0 返回 0
        if (rest == 0) {
            return 0;
        }
        if (i == arr.length && rest < arr[i - 1]) {
            return -1;
        }

        rest = rest - arr[i - 1];
        // 一个面值的可以取任意张 怎么解决

        return process2(arr, i + 1, rest);


    }

    // version 3.0

    public static int process3(int[] arr, int i, int rest) {
        // basecase
        // 已经没有面值能够考虑了，返回-1 （返回-1的时候怎么处理） ; 如果rest == 0 返回 0
        if (arr.length == i) {
            return rest == 0 ? 0 : -1;
        }
        // 返回结果初始设置为 -1
        int res = -1;
//        rest = rest - arr[i - 1];
//        // 一个面值的可以取任意张 怎么解决
//
//        return process2(arr, i + 1, rest);

        /** 这里出现了分支  递归的分支  整理 返回结果  */

        for (int j = 0; arr[i] * j <= rest; j++) {
            rest = rest - arr[i] * j;
            int nextRes = process3(arr, i + 1, rest);
            if (nextRes == -1) {
                continue;
            }
            //res = res == -1 ? res2 + j : Math.min(res, res2 + j);

            if (res == -1) {
                res = nextRes + j;
            } else {
                res = Math.min(res, nextRes + j);
            }

            /** 这里返回结果处理的逻辑有点诡异
             *  主要还是没有分析清楚
             * */
            //res = Math.max(res, res + res2 + j);
        }
        return res;
    }


    /**
     * 修改为动态规划
     */

    public int minCoins(int[] arr, int aim) {

        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        int N = arr.length;

        int dp[][] = new int[N + 1][aim + 1];

        // basecase

        for (int i = 0; i < aim + 1; i++) {
            dp[N][i] = -1;
        }
        dp[N][0] = 0;


        for (int i = N - 1; i > -1; i--) {
            for (int j = 0; j < aim + 1; j++) {
                if (dp[i + 1][j] != -1) {
                    dp[i][j] = dp[i + 1][j];
                }
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != -1) {
                    if (dp[i][j] == -1) {
                        dp[i][j] = dp[i][j - arr[i]] + 1;
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - arr[i]] + 1);
                    }
                }

            }
        }

        return dp[0][aim];


    }


    public static void main(String[] args) {

        int[] arr = {5, 3};
        System.out.println(process3(arr, 1, 2));
    }


}
