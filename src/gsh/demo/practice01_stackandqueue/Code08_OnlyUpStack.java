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
     * 一个 value    由大到小 的栈  栈顶到栈底是递减的   找到的是 是比它小的值
     * 如果 value 比 前边的大 就压入栈中
     * <p>
     * 如果 value 比 前边的小 就 弹出
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

        for (int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()){
                stack.push(new Node(i, arr[i]));
                continue;
            }

            while (!stack.isEmpty() && stack.peek().value > arr[i]) {
                Node node1 = stack.pop();
                res[node1.index][1] = i;
                res[node1.index][0] = stack.isEmpty() ? -1 : stack.peek().index;
            }
            stack.push(new Node(i, arr[i]));
        }

        while (!stack.isEmpty()) {
            Node node2 = stack.pop();
            res[node2.index][1] = -1;
            res[node2.index][0] = stack.isEmpty() ? -1 : stack.peek().index;
        }

        return res;

    }


    public static void main(String[] args) {

        int[] arr = {3, 4, 1, 5, 6, 2, 7};

        int[][] res = getRightWay(arr);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + "  ");
            }
            System.out.println();
        }

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
