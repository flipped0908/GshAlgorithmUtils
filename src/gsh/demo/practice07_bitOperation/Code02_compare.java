package gsh.demo.practice07_bitOperation;

/**
 * 不用做任何比较判断出两个数中较大的一个
 */
public class Code02_compare {


    /**
     * n = 1  return 0
     * n = 0  return 1
     */
    public static int flip(int n) {
        return n ^ 1;
    }


    /**
     * 返回 1 正数
     * <p>
     * 返回 0 负数
     */
    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }


    public int getMax1(int a, int b) {

        int c = a - b;

        int sca = sign(c);

        int scb = flip(sca);

        return sca * a + scb * b;
    }


    // 解决意溢出问题
    public int getmax2(int a, int b) {

        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difsab = sa ^ sb;
        int samb = flip(difsab);
        int returnA = difsab * sa + samb * sc;
        int retrunB = flip(returnA);

        return a * returnA + b * retrunB;

    }


    public static void main(String[] args) {
        System.out.println(sign(5));
    }


}
