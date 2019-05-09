package gsh.demo.practice04_RecursionAndDynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * 子数组异或和为0的最多划分
 * 数组异或和为 0  把数组中所有的数异或起来得到的值
 * 给定一个数组，可能有 正  负  0 ， 可以随意把切成若干个不相容的子数组
 * 求异或和为 0 的 子数组最多能有多少个
 * <p>
 * 要求 如果arr的长度为 N 时间复杂度为 O（N）
 */

public class Code12_SubStringXORsumIsZeroMost {


    public int mostdp(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[arr.length];
        dp[0] = arr[0] == 0 ? 1 : 0;
        int eor = arr[0];
        map.put(eor, 0);
        for (int i = 1; i < arr.length; i++) {
            eor ^= arr[i];
            if (map.containsKey(eor)) {
                int index = map.get(eor);
                dp[i] = dp[index] + 1;
            }
            dp[i] = Math.max(dp[i - 1], dp[i]);
            map.put(eor, i);
        }
        return dp[arr.length - 1];

    }


}
