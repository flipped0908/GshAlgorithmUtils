package gsh.demo.practice07_bitOperation;

/**
 * 只用位运算符 不用算符运算符 实现 加减乘除
 */

public class Code04_operation {


    /**
     * 相加 分为两步
     * <p>
     * 只算相加 不算进为  就是XOR
     * <p>
     * 只算仅为不算 相加  A&b <<1   先与在左移
     * <p>
     * 在异或 在与了左移
     * <p>
     * 直到 与为0  不在进位为止
     */


    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }


    public static int negNum(int n) {
        return add(~n, 1);
    }

    public static int minux(int a, int b) {
        return add(a, negNum(b));
    }


    /**
     * 类似 10 进制相乘
     * <p>
     * 123*456
     * = 123*10^0*6 + 123*10^1*5 + 123*10^2*4
     */
    public static int mulit(int a, int b) {
        int res = 0;
        while (b != 0) {
            int b0 = b & 1;
            a = a << 1;
            if (b0 == 1) {
                res = add(res, a);
            }
            b = b >> 1;
        }
        return res;
    }

    public static boolean isneg(int n) {
        return n < 0;
    }

    public static int div(int a, int b) {

        int x = isneg(a) ? negNum(a) : a;
        int y = isneg(b) ? negNum(b) : b;

        int res = 0;

        for (int i = 31; i > -1; i = minux(i, 1)) {
            if ((x >> i) >= y) {
                res = res | (1 << i);
                x = minux(x, y << i);
            }
        }
        return isneg(a) ^ isneg(b) ? negNum(res) : res;

    }


}
