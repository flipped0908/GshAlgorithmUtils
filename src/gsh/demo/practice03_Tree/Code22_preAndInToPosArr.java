package gsh.demo.practice03_Tree;

import gsh.utils.MyError;

/**
 * 通过先和中 生成 后序数组
 */

public class Code22_preAndInToPosArr {


    public int[] getpos(int[] pre, int[] in) {

        return null;
    }

    public static int[] process(int[] pre, int[] in, int start, int end) {

        if (end == start) {
            int[] res = {pre[start]};
            return res;
        }
        if ((end - start) == 1) {
            return in;
        }

        int endnum = pre[start];

        int len = (end - start) / 2;

        int[] preHalf = process(getarr(pre, start + 1, start + len), getarr(in, start, start + len), start, start + len - 1);

        int[] posHalf = process(getarr(pre, start + len + 1, end), getarr(in, start + len, end - 1), start, start + len - 1);

        return getarr1(preHalf, posHalf, endnum);

    }


    public static int[] getarr1(int[] arr, int[] arr2, int num) {

        int[] res = new int[arr.length + arr2.length + 1];

        for (int i = 0; i < res.length - 1; i++) {
            if ((i + 1) < arr.length) {
                res[i] = arr[i];
            } else {
                res[i] = arr2[i - arr.length];
            }
        }
        res[res.length - 1] = num;

        return res;

    }

    public static int[] getarr(int[] arr, int start, int end) {

        if (end < start) {
            MyError.myerror("out of index array");
        }
        int[] res = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            res[i - start] = arr[start];
        }
        return res;

    }


}
