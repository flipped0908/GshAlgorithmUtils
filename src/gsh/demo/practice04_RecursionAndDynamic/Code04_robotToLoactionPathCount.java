package gsh.demo.practice04_RecursionAndDynamic;

/**
 * 机器人到达指定位置的方法数
 * 一排 N个位置 1~N
 * 机器人在M  机器人 走 K 步 来到位置P 的方法
 * 机器人每次走一步
 * MNPK 四个参数 返回方法数
 */
public class Code04_robotToLoactionPathCount {

    /**
     * 递归实现
     */


    // version 1.0
    public static void process(int remianstpes, int curLocation, int aimlocation, int num, int res) {


        if (remianstpes == 0) {
            if (curLocation == aimlocation) {
                res = res + 1;
            }
            return;
        }

        remianstpes--;


        if (curLocation == 1) {
            process(remianstpes, 2, aimlocation, num, res);
        }
        if (curLocation == num) {
            process(remianstpes, num - 1, aimlocation, num, res);
        }

        process(remianstpes, curLocation + 1, aimlocation, num, res);

        process(remianstpes, curLocation - 1, aimlocation, num, res);

    }

    /**
     * version 1.0 中 把 结果放在了函数中 结果没有返回  那么递归个什么呢  计算的结果res 并没有返回 res是局部变量
     */


    // version 2.0
    public static int process2(int remianstpes, int curLocation, int aimlocation, int num) {

        if (remianstpes == 0) {
            if (curLocation == aimlocation) {
                return 1;
            }
            return 0;
        }

        remianstpes--;

        if (curLocation == 1) {
            return process2(remianstpes, 2, aimlocation, num);
        }
        if (curLocation == num) {
            return process2(remianstpes, num - 1, aimlocation, num);
        }

        int r1 = process2(remianstpes, curLocation + 1, aimlocation, num);

        int r2 = process2(remianstpes, curLocation - 1, aimlocation, num);

        return r1 + r2;

    }

    /**
     * 动态规划
     */

    public static int walks(int remainsteps, int curLocation, int aimLocation, int num) {
        if (remainsteps == 0 || curLocation > num || aimLocation > num || aimLocation < 1 || curLocation < 1) {
            return 0;
        }

        int[][] dp = new int[remainsteps][num];

        for (int i = 0; i < num; i++) {
            dp[0][i] = 0;
        }
        dp[0][aimLocation] = 1;

        for (int i = 1; i < remainsteps; i++) {
            for (int j = 0; j < num; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][1];
                } else if (j == num - 1) {
                    dp[i][num - 1] = dp[i - 1][num - 2];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }

            }
        }
        return dp[remainsteps - 1][curLocation];
    }


    // 状态压缩
    public static int walks1(int remainsteps, int curLocation, int aimLocation, int num) {
        if (remainsteps == 0 || curLocation > num || aimLocation > num || aimLocation < 1 || curLocation < 1) {
            return 0;
        }

        // int[][] dp = new int[remainsteps][num];

        int[] dp = new int[num];

        for (int i = 0; i < num; i++) {
            dp[i] = 0;
        }
        dp[aimLocation] = 1;

        for (int i = 1; i < remainsteps; i++) {
            int tmp = dp[0];
            for (int j = 0; j < num; j++) {

                if (j == 0) {
                    dp[0] = dp[1];
                } else if (j == num - 1) {
                    dp[j] = tmp;
                } else {
                    int t = dp[j];
                    dp[j] = tmp + dp[j + 1];
                    tmp = t;
                }
            }
        }
        return dp[curLocation];
    }


    public static void main(String[] args) {
        int res = 0;
        process(3, 2, 3, 5, res);
        System.out.println(res);

    }


}
