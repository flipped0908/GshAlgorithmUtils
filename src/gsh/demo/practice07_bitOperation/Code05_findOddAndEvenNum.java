
package gsh.demo.practice07_bitOperation;

/**
 * 在其他数都出现偶数次的数组中，找出出现奇数次的数
 * 时间复杂度 O(N)
 * <p>
 * 如果做只有两个数出现了奇数次 找出这两个数
 */
public class Code05_findOddAndEvenNum {
    public static int getOddTimesNum(int[] arr) {

        int a = 0;

        for (int i = 0; i < arr.length; i++) {
            a = a ^ arr[i];
        }
        return a;

    }

    public static void getOddTimesNum2(int[] arr) {

        int a = 0;

        for (int i = 0; i < arr.length; i++) {
            a = a ^ arr[i];
        }

        int tmp = a & (~a + 1);

        int b = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & tmp) != 0) {
                b = b ^ arr[i];
            }
        }
        int c = b ^ a;
        System.out.println(c + "  " + b);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 3, 5, 2, 1};
        getOddTimesNum2(arr);
    }


}
