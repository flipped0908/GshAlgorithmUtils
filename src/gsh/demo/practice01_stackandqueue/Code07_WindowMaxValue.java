package gsh.demo.practice01_stackandqueue;


import java.util.LinkedList;

/**
 * double *
 * 生成窗口最大值数组
 * <p>
 * 输入一个数组 和 窗口的大小  一共产生n-w+1个窗口的最大值
 */

public class Code07_WindowMaxValue {

    public static int[] getMacWindowArr(int[] arr, int w) {

        if (arr.length < w) {
            return new int[]{};
        }

        int len = arr.length;

        int[] res = new int[len - w + 1];

        // 放入数组元素对应的 index
        LinkedList<Integer> queue = new LinkedList<Integer>();

        queue.add(0);

        for (int i = 1; i < w; i++) {
            if (arr[i] < arr[queue.getFirst()]) {
                queue.add(i);
            } else {
                queue.clear();
                queue.add(i);
            }
        }
        int resIndex = 0;
        res[resIndex] = queue.getFirst();

        for (int i = w; i < len; i++) {

            if (queue.size() == w) {
                queue.pollFirst();
            }

            if (arr[i] < arr[queue.getFirst()]) {
                queue.add(i);
                int k = queue.getFirst();
                res[++resIndex] = k;
            } else {
                queue.clear();
                queue.add(i);
                res[++resIndex] = i;
            }
        }

        return res;
    }


    public static void main(String[] args) {

        int[] arr = new int[]{4, 3, 5, 4, 3, 3, 6, 7};

        int[] res;

        res = getMacWindowArr(arr, 3);

        for (int i = 0; i < res.length; i++) {
            System.out.print(arr[res[i]] + " ");
        }

    }


    /**
     * teacher
     */

    public static int[] getMaxWinow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();

        int[] res = new int[arr.length - w + 1];

        int index = 0;

        for (int i = 0; i < arr.length; i++) {

            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }

            qmax.addLast(i);

            if (qmax.peekLast() == i - w) {
                qmax.pollFirst();
            }

            if (i > w - 1) {
                res[index + 1] = arr[qmax.peekFirst()];
            }


        }

        return res;


    }


    /**
     *
     * 总结：
     *
     * 因为逻辑的混乱，造成了写代码的时间浪费 和 代码内部的逻辑混乱
     *
     * 所以 写代码 很快 但是 逻辑和流程一定要清晰
     *
     * 但是很多时候也是在写错误代码的过程中 调试
     *
     * 要区分写代码过程中的逻辑混乱 和 bug 的区别
     *
     * 一句话：只要是复杂的不清楚的逻辑，基本上就是错了
     *
     * 因为逻辑只要拆分的细致和清楚，写代码是非常容易的
     *
     */



}
