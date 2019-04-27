package gsh.demo.practice04_RecursionAndDynamic;

/**
 * 打气球的最大分数
 */
public class Code06_balloonHighestScore {

    // arr = {2,3,5}

    // help = {1,2,3,5,1}

    // N=3 L=1, R=N

    // 递归 version 1.0

    private static int count =0;


    public static int process(int[] arr, int L, int R) {
        System.out.println(count++);

        if (L == R) {
            return arr[L] * arr[L - 1] * arr[R + 1];
        }
        int res = Math.max(arr[L - 1] * arr[L] * arr[R + 1] + process(arr, L + 1, R),
                arr[L - 1] * arr[R] * arr[R + 1] + process(arr, L, R - 1));
        // 中间气球最后被打爆
        for (int i = L + 1; i < R; i++) {
            int res1 = process(arr, L, i - 1) + arr[i] + process(arr, i + 1, R);
            res = Math.max(res, res1);
        }
        return res;
    }


    /**
     *  动态规划
     */

    public static  int getCountDy(int[] arr){
        // inputcheck()


        return 0;
    }


    public static void main(String[] args) {

        int[] arr = {1,2,3,5,6,7,8,1};
        process(arr,1,6);
        // System.out.println(process(arr,1,3));
        System.out.println(count);

    }


}
