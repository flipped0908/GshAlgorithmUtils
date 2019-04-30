package gsh.zuocom.sort;

import java.lang.reflect.Array;

public class heapSort {
    // 数组 堆排序
    public static void sort(int[] arr) {
        // 把 大元素 上移动
        for (int i = 0; i < arr.length; i++) {
            insert(arr, i);
        }
        // 把 大元素 和 头元素交换 头元素下沉 保证 头元素最大
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            down(arr, 0, size);
            swap(arr, 0, --size);
        }
    }


    public static void down(int[] arr, int index, int size) {
        int tmpIndex = index;
        while (tmpIndex * 2 + 1 < size) {
            int nextIndex = tmpIndex * 2 + 1;
            if (tmpIndex * 2 + 2 < size) {
                if (arr[tmpIndex * 2 + 1] < arr[tmpIndex * 2 + 2]) {
                    nextIndex = tmpIndex * 2 + 2;
                }
            }
            if (arr[tmpIndex] > arr[nextIndex]) {
                break;
            }
            swap(arr, tmpIndex, nextIndex);
            tmpIndex = nextIndex;
        }
    }


    public static void insert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 8, 1, 7, 2, 6, 3};
        sort(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

}
