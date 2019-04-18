package gsh.demo.practice01_stackandqueue;

import java.util.Stack;

/**
 * double*
 * 给定一个不含有重复值的数组 arr 找到每一个 i位置的左边和右边离 i最近且 值比arr[i] 小的位置
 * <p>
 * 返回一个二维数组
 */
public class Code08_OnlyUpStack {

    public static class Node {

        public int index;
        public int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

    }

    /**
     * 思路：
     * 一个 value 由大到小 的栈
     * 如果 value 比 前边的小 就压入栈中
     * <p>
     * 如果 value 比 前边的大 就 弹出
     * 弹出的时候开始 记录 结果 前边这个数 右边的值是新入的这个数的index  左边是他前边的数的dindex的值
     * <p>
     * 当数组结束时候  开始全部弹出栈
     */

    public static int[][] getRightWay(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int[][] res = new int[arr.length][2];

        Stack<Node> stack = new Stack<>();

        stack.push(new Node(0, arr[0]));

        for (int i = 1; i < arr.length; i++) {
            int tmp = stack.peek().value;
            if (arr[i] > tmp) {
                Node node1 = stack.pop();
                res[node1.index][1] = i;
                res[node1.index][0] = stack.isEmpty() ? -1 : stack.peek().index;
            } else {
                stack.push(new Node(i, arr[i]));
            }
        }


        while (!stack.isEmpty()) {

            Node node2 = stack.pop();
            res[node2.index][1] = -1;
            res[node2.index][0] = stack.isEmpty() ? -1 : stack.peek().index;

        }

        return res;

    }

    /**
     *
     * 总结 ：
     * 这道题目 开始的时候 写清楚了思路， 很快就把代码码出来了
     *
     * 虽然事先知道 单调栈的 规律  但是 这种做题的方法论 还是可以的
     *
     *
     */


}
