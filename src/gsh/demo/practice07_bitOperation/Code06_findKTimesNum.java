package gsh.demo.practice07_bitOperation;


/**
 * 在其他数出现k次 只有一个数出现了一次  找出这个数
 */
public class Code06_findKTimesNum {

    // 转化为 k 进制 的数

    public static int[] changeToK(int a, int k) {

        int[] res = new int[32];
        int index = 0;
        while (a > 0) {
            res[index++] = a % k;
            a = a / k;
        }
        return res;

    }


    public static int changeTo10(int a[], int k) {

        int res = 0;
        int tmp = 1;
        for (int i = 0; i < a.length; i++) {
            res += a[i] * tmp;
            tmp = k * tmp;
        }

        return res;

    }


    // 两个k 进制的数 无进位相加

    public static int[] add(int[] a, int[] b, int K) {
        int[] res = new int[32];
        for (int i = 0; i < res.length; i++) {
            res[i] = (a[i] + b[i]) % K;
        }
        return res;
    }


    public static int getRes(int[] arr, int K) {

        int[] tmp = new int[32];
        for (int i = 0; i < arr.length; i++) {
            int[] a = changeToK(arr[i], K);
            tmp = add(a, tmp, K);
        }
        return changeTo10(tmp, K);
    }

}
