package gsh.demo.practice03_Tree;

/**
 * 根据后序数组重建搜索二叉树
 * <p>
 * 数组没有重复值
 */
public class Code14_rebulidBinarrySearchTree {

    /**
     * 判断一个数组是否是一个二叉树的 后序数组
     */


    public static boolean ispost(int[] arr, int start, int end) {
        if (start == end) {
            return true;
        }
        boolean res = true;
        boolean flg = true;
        int index = 0;
        for (int i = start; i < end; i++) {
            if (arr[i] > arr[end]) {
                flg = false;
                index = i;
            }
            if (!flg) {
                if (arr[i] < arr[end]) {
                    res = false;
                }
            }
        }

        if (!res) {
            return false;
        }
        /**
         * 边界条件忘记考虑了
         */
        if (flg || index == start) {
            return ispost(arr, start, end - 1);
        }

        return ispost(arr, start, index - 1) && ispost(arr, index, end);


    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 6, 8, 9, 7};
        System.out.println(ispost(arr, 0, arr.length - 1));

    }


}
