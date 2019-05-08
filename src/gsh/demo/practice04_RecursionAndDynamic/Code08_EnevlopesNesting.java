package gsh.demo.practice04_RecursionAndDynamic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 信封嵌套问题
 * <p>
 * 给定一个N行2 列的二维数组 ，分别代表信封的长和宽
 * <p>
 * 返回信封对多嵌套多少层
 * 时间复杂度 O(N*LongN)
 */
public class Code08_EnevlopesNesting

{

    /**
     * 信封的长度按照从小到大的顺序排列
     * 在把信封的宽度按照从大到小的顺序排列
     * <p>
     * 在求解出来信封宽度的最长递增子序列
     */

    public class Envelope {
        public int len;
        public int wid;

        public Envelope(int l, int w) {
            len = l;
            wid = w;
        }
    }


    public class EnvelopComparator implements Comparator<Envelope> {

        @Override
        public int compare(Envelope o1, Envelope o2) {
            return o1.len != o2.len ? o1.len - o2.len : o2.wid - o1.wid;
        }
    }

    public Envelope[] getarr(int[][] martix) {
        if (martix == null || martix.length == 0) {
            return null;
        }
        Envelope[] envelopes = new Envelope[martix.length];

        for (int i = 0; i < martix.length; i++) {
            envelopes[i] = new Envelope(martix[i][0], martix[i][1]);
        }
        Arrays.sort(envelopes, new EnvelopComparator());
        return envelopes;
    }


    public int getlongest(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        int right = 0;
        dp[0] = 1;
        ends[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int k = arr[i];
            int l = 0;
            int r = right;
            while (l <= r) {
                int m = (l + r) / 2;
                if (k > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
                right = Math.max(l, right);
                ends[l] = k;
            }
        }
        return right + 1;
    }


}
