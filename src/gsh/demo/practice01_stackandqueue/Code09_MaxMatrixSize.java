package gsh.demo.practice01_stackandqueue;

/**
 * 返回矩阵中 最大矩阵区域
 * <p>
 * 1 1 1  0     返回 3
 * <p>
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0     返回 6
 * <p>
 * 解题思路   把问题分解为  第一行  第 1，2 行  第 1，2，3 行
 * <p>
 * 求解新分类的矩形中的最大值
 * <p>
 * 最小子问题就是求出单调栈 一个数组中内个元素 到它两边的 最小值 决定了最大可以形成的矩形面积
 */

public class Code09_MaxMatrixSize {


    /**
     * 获取每一行中size面积最大的值   arr[]
     * <p>
     * int[] arr = { 4, 3, 2, 5, 6};
     * <p>
     * -1   1
     * -1   2
     * -1  -1
     * 2  -1
     * 3  -1
     */
    public static int getMaxSizeOneRow(int[] arr) {

        int[][] res = Code08_OnlyUpStack01.getRightWay(arr);

        int max = 0;

        for (int i = 0; i < res.length; i++) {
            int[] k = res[i];
            int height = arr[i];
            int hl = (k[0] == -1) ? -1 : k[0];
            int hr = (k[1] == -1) ? arr.length : k[1];
            int w = hr - hl - 1;
            max = Math.max(max, w * height);
        }
        return max;
    }

    /**
     *  获取每一行的值
     */
    public static int[] getOneRow(int[] arrold, int[] arrone) {

        if (arrold == null || arrone == null || arrold.length != arrold.length) {
            return null;
        }

        int[] res = new int[arrold.length];
        for (int i = 0; i < arrold.length; i++) {
            if (arrone[i] != 0) {
                res[i] = arrold[i] + arrone[i];
            } else {
                res[i] = 0;
            }
        }
        return res;
    }


    /**
     *  获取最大的值
     */
    public static int getMaxSizeMain(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            throw new RuntimeException(" matrix is empty ");
        }

        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        newMatrix[0] = matrix[0];

        for (int i = 1; i < matrix.length; i++) {
            newMatrix[i] = getOneRow(newMatrix[i - 1], matrix[i]);
        }

        int res = 0;

        for (int i = 0; i < newMatrix.length; i++) {
            res = Math.max(res, getMaxSizeOneRow(newMatrix[i]));
        }

        return res;
    }

    public static void main(String[] args) {

        int[] arr = {4, 3, 2, 5, 6, 5};

       // System.out.println(getMaxSizeOneRow(arr));

        int[] a = {1,2,3};

        int[][] b = {{1,0,0,0,1,1,1},
                     {1,0,0,0,1,0,1},
                     {1,0,0,0,0,1,0},
                     {1,0,0,1,1,1,1},
                     {1,0,0,1,1,1,1}};

        System.out.println(getMaxSizeMain(b));


    }

}
