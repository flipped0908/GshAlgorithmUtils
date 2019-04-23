package gsh.demo.practice04_RecursionAndDynamic;

import gsh.utils.MyError;

/**
 * 斐波那契数列问题的递归和动态规划
 */

public class Code01_SameExample {

    // f(n) = f(n-1)+f(n-2)
    // f(1) = 1;
    // f(2) = 2;
    // f(3) = 3;

    public static int getRoalds(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return getRoalds(n - 1) + getRoalds(n - 2);
    }

    /**
     * [ f(n) , f(n-1)] = [f(n-1),f(n-2)] * [[ 1 , 1]
     * [ 1 , 0]]
     * <p>
     * [f(n),f(n-1)] = [f(2),f(2)] *{[[1,1][1,0]]^(n-2)}
     */

    public static int getRoalds1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixpower(base, n - 2);
        return res[0][0] + res[1][0];

    }


    public static int[][] matrixpower(int[][] m, int p) {
        if (m.length != m[0].length) {
            MyError.myerror("matrix is not n*n");
        }
        int size = m.length;
        int[][] res = new int[size][size];
        for (int i = 0; i < size; i++) {
            res[i][i] = 1;
        }
        int[][] tmp = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = mulimatrix(res, tmp);
            }
            tmp = mulimatrix(tmp, tmp);
        }

        return res;

    }

    public static int[][] mulimatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;

    }


    public static void main(String[] args) {
        System.out.println(getRoalds1(5));
    }


}
