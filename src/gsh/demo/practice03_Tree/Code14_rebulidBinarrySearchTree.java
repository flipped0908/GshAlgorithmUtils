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
        int[] arr = {3, 5, 4, 6, 8, 9, 7};
        System.out.println(ispost(arr, 0, arr.length - 1));
        TreeNode head = arrToST2(arr, 0, arr.length - 1);
        //TreeUtils.printTree(head);

    }


    // version 1.0

    public static TreeNode arrToST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode head = new TreeNode(arr[end]);
        //找到左边最右一个比它小的
        int t = start;
        if (arr[start] > arr[end]) {
            //  head.left = null;
        } else {
            while (arr[t] < arr[end]) {
                t++;
            }
            t--;
            //  head.left = new TreeNode(arr[t]);
        }

        // 找到左边最后一个比它大的
        if (arr[end - 1] < arr[end]) {
            //  head.right = null;
            t = end - 1;
        } else {
            //  head.right = new TreeNode(arr[end - 1]);
            t = start - 1;
        }

        head.left = arrToST(arr, start, t);
        head.right = arrToST(arr, t + 1, end - 1);

        return head;

    }

    // version 2.0

    public static TreeNode arrToST2(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        // 这里处理叶子节点
        if (start == end) {
            return new TreeNode(arr[end]);
        }
        TreeNode head = new TreeNode(arr[end]);
        int t = start;
        if (arr[start] > arr[end]) {
            t = start - 1;
        } else if (arr[end - 1] < arr[end]) {
            t = end - 1;
        } else {
            while (arr[t] < arr[end]) {
                t++;
            }
            t--;
        }
        head.left = arrToST2(arr, start, t);
        head.right = arrToST2(arr, t + 1, end - 1);
        return head;
    }


    // 总结： 忘记考虑边界条件 造成了栈溢出
}
