package gsh.demo.practice09_arrayandmatrix;


import gsh.utils.MyUtils;

/***
 * 找到无序数组中最小的k个数
 */

public class Code04_finTopKSamllestNum {


    public static int[] getTopK(int[] arr, int k) {
        if (arr == null || k < 0) {
            throw new RuntimeException(" input error");
        }
        if (arr.length <= k) {
            return arr;
        }

        int len = arr.length;

        int[] kHeap = new int[k];

        for (int i = 0; i != k; i++) {
            insert(kHeap, i, arr[i]);
        }

        for (int i = k; i < len; i++) {
            if (arr[i] < kHeap[0]) {
                kHeap[0] = arr[i];
                help(kHeap, 0, k);
            }
        }


        return kHeap;
    }


    public static void insert(int[] arr, int i, int value) {

        // inputcheck

        arr[i] = value;
        while (i > 0) {
            if (arr[i] > arr[(i - 1) / 2]) {
                swap(arr, i, (i - 1) / 2);
                i = (i - 1) / 2;
            } else {
                break;
            }
        }

    }


    public static void help(int[] arr, int index, int heapsize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int lagest = index;
        while (left < heapsize) {
            if (arr[left] > arr[index]) {
                lagest = left;
            }
            if (right < heapsize && arr[right] > arr[lagest]) {
                lagest = right;
            }
            if (lagest != index) {
                swap(arr, index, lagest);
            } else {
                break;
            }
            index = lagest;
            left = lagest * 2 + 1;
            right = lagest * 2 + 2;
        }
    }


    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    public static void main(String[] args) {
       // int[] arr = MyUtils.generateRandomArray(20, 100);
       // MyUtils.printArray(arr);

        int[] arr =  {1,2,3,4,5,7,8,3,4,2,1};

        int[] res = getTopK(arr,4);

        MyUtils.printArray(res);

    }


}
