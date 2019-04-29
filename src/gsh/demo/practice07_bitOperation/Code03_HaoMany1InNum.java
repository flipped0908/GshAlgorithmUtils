package gsh.demo.practice07_bitOperation;

import sun.security.util.BitArray;

/**
 * 2进制数中有多少个1
 */
public class Code03_HaoMany1InNum {

    public static int getcnt(int a) {

        int res = 0;
        while (a != 0) {
            if ((a & 1) == 1) {
                res++;
            }
            a >>= 1;
        }
        return res;
    }


    public static int getCnt2(int a) {
        int res = 0;
        while (a != 0) {

            a = a & (a - 1);

            res++;

        }
        return res;
    }

    public static int getCnt3(int a) {
        int res = 0;
        while (a != 0) {

            // 得到最后一个1以后的数
            int tmp = a & (~a + 1);

            a -= tmp;

            res++;

        }
        return res;


    }

    public static void main(String[] args) {

        int b = 1450000;

        System.out.println(Integer.toBinaryString(b));

        System.out.println(Integer.toBinaryString(-b));

        System.out.println(Integer.toBinaryString(-b & b));


    }


}
