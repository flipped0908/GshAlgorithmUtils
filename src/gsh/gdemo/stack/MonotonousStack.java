package gsh.gdemo.stack;

import gsh.utils.MyError;

import java.util.Stack;

/**
 * 单调栈
 * <p>
 * 题目 给定一个不含有重复数的数组arr 找到每一个位置左边和右边离i位置最且比arr[i]小的的位置，返回所有信息
 *
 *
 * 单调栈本身是以种方法，也可以作为其他方法的子方法
 *
 *
 * 典型的应用就是找一列数中某一个位置两边比它大或者比它小的数
 *
 *
 */
public class MonotonousStack {

    /**
     * input  int[]
     * <p>
     * return int[][]
     * <p>
     * 使用栈结构 核心思想
     * <p>
     * 栈中放入的是元素的位置就是数组下标
     * <p>
     * if
     * 当新加元素比栈顶元素大，入栈
     * else
     * 栈顶元素出栈 记录结果
     * if 栈空
     * 左边记为 -1
     * ele
     * 走边记为栈顶的值
     * 右边为当前插入值的位置
     * <p>
     * 如果数组用完，栈不为空，依次弹出栈
     * 左边为 弹出后 栈顶元素的值
     * 右边为 -1
     */


    public static int[][] getLessRes(int[] arr) {
        if (arr == null || arr.length == 0) {
            MyError.myerror("input arr is empty");
        }
        int len = arr.length;
        int res[][] = new int[len][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int top = stack.pop();
                res[top][0] = stack.isEmpty() ? -1 : stack.peek();
                res[top][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            res[top][1] = -1;
            res[top][0] = stack.isEmpty() ? -1 : stack.peek();
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 5, 2, 6, 7};

        int[][] res = getLessRes(arr);
        System.out.println();

    }


}