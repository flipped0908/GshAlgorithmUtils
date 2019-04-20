package gsh.demo.practice01_stackandqueue;


import java.util.LinkedList;

/**
 * 给定数组中， 有多少个子数组 满足 最大值减去最小值   <= num
 * 要求 如果数组长度为 n  时间复杂度为O（N）
 */


public class Code10_GetSubArrCount {


    /**
     *
     * 时间复杂度高的算法
     *
     * f1（int[] arr） 判断数组中的最大值和最小值 是否满足条件 O(N)
     *
     * f2 (int[] arr)  求出所有的子数组  O（N^2）
     *
     * 整体的时间复杂度 O（N^3）
     */


    // 首先 这个时间复杂度的要求 只能是 一遍 循环  就要求出结果

    /***
     *
     *  优化的解法
     *  空间 换 时间
     *  一个数组中最大值 和最小值 满足条件  那么这个数组中的子数组都满足条件
     *
     *  维护两个记录窗口的 双端队列
     *
     *  每个元素进出队列的次数为1 最终的时间复杂度为 O（N）
     *
     *  窗口向右扩张 一旦扩张不动  先计算结果 记录结果  然后 左边的窗口向右扩张 重复右端窗口向右扩张
     *
     */


    // version 1.0
    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = 0;
        // 记录窗口位置
        int i = 0;
        int j = 0;

        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();

        qmax.add(0);
        qmin.add(0);

        while (i < arr.length) {
            while (j < arr.length) {
                if ((arr[qmax.peekLast()] - arr[qmin.peekLast()]) <= num) {
                    qmax.addLast(j);
                    j++;
                } else {
                    qmax.pollFirst();
                    res += j - i;
                    break;
                }
            }
            i++;
            qmin.add(i);
            qmin.pollFirst();
        }
        return res;
    }


    // version 2.0

    /**
     * 思路没有理清楚 版本1.0  感觉逻辑很混乱
     * <p>
     * 逻辑的欠缺  队列的边界条件没有考虑清楚， 两个队列维护的内容有点混乱
     * <p>
     * 在 1.0 的基础上 修改 2.0
     * <p>
     * 1.0 的时候 完全没有考虑清楚两个队列是怎么维护和  和维护两个队列的意义 以及 i和 j 递增的原因是什么
     */
    public static int getNum2(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = 0;
        // 记录窗口位置
        int i = 0;
        int j = 0;

        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();

        /** 这些元素是都要进队列的*/
        while (i < arr.length) {
            while (j < arr.length) {
                //j 右移

                // 维护队列  小队列 为空 或者没有到j的时候都要维护队列
                if (qmin.isEmpty() || qmin.peekLast() != j) {
                    // 更新小队列

                    while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                        qmin.pollLast();
                    }

                    qmin.addLast(j);

                    // 更新大的队列

                    while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                        qmax.pollLast();
                    }

                    qmax.addLast(j);
                }


                if ((arr[qmax.peekLast()] - arr[qmin.peekLast()]) > num) {
                    break;
                }

                j++;
            }

            // break 时候 计算 res的值

            res += j - i;

            // 大队列的第一个值 和 小队列的第一个值 计算完了
            // 要移除第一个元素
            if (!qmax.isEmpty()) {
                qmax.pollFirst();
            }
            if (!qmin.isEmpty()) {
                qmin.pollFirst();
            }

            // i 右移动
            i++;
        }
        return res;
    }


}
