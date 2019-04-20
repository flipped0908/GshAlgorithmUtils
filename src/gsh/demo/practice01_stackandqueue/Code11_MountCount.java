package gsh.demo.practice01_stackandqueue;

import java.util.Stack;

/**
 * 可见山峰对数量
 * <p>
 * 要求 如果arr的长度为N 没有重复值的情况下时间复杂度达到O（1） 有重复值的情况下 时间复杂度达到 O（N）
 */


public class Code11_MountCount {


    public static class Record {

        public int value;

        public int times;

        public Record(int value) {
            this.value = value;
            this.times = 1;
        }

    }

    public static int nextIndex(int index, int size) {
        return index + 1 == size ? 0 : index + 1;
    }

    public static int c2k(int k) {
        if (k < 2) {
            return k;
        }
        return k * (k - 1) / 2;
    }

    public int getMountCount(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int res = 0;

        // 单调栈 下大上小

        Stack<Record> stack = new Stack<>();

        int size = arr.length;

        int maxIndex = 0;

        // 找到环中的最大的一个位置
        for (int i = 0; i < size; i++) {
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }

        // 从最大的数开始

        stack.push(new Record(arr[maxIndex]));

        // 从第max index 开始 压栈
        //  arr { 2,3,4,5,7,8}  n=5  maxindex = 3    4 - 5 - 0 -1 -2 -3

        int nextIndex = nextIndex(maxIndex, size);

        // 压栈
        while (maxIndex != nextIndex) {

            // 出栈
            while (!stack.isEmpty() && stack.peek().value < arr[nextIndex]) {
                Record record = stack.pop();
                res += 2 * record.times + record.times > 1 ? c2k(record.times) : 0;
            }

            if (stack.isEmpty()) {
                stack.push(new Record(arr[nextIndex]));
                nextIndex = nextIndex(nextIndex, size);
                continue;
            }
            if (!stack.isEmpty() && stack.peek().value == arr[nextIndex]) {
                stack.peek().times = stack.peek().times + 1;
                nextIndex = nextIndex(nextIndex, size);
                continue;
            }
            if (!stack.isEmpty() && stack.peek().value > arr[nextIndex]) {
                stack.push(new Record(arr[nextIndex]));
                nextIndex = nextIndex(nextIndex, size);
            }

        }

        // 数组循环完毕

        while (stack.size() > 2) {
            Record record = stack.pop();
            res += 2 * record.times + record.times > 1 ? c2k(record.times) : 0;
        }

        if (stack.size() == 2) {
            Record record = stack.pop();
            if (stack.peek().times > 1) {
                res += 2 * record.times + record.times > 1 ? c2k(record.times) : 0;
            } else {
                res += record.times + record.times > 1 ? c2k(record.times) : 0;

            }
        }

        if (stack.size() == 1) {
            if (stack.peek().times > 1) {
                res += c2k(stack.peek().times);
            }
        }

        return res;

    }


}
