package gsh.zuocom.heap;

public class Heap {

    /**
     * 根 =（index-1）/2
     * 左 = 根*2+1
     * 右 = 根*2+2
     */


    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            heapInset(arr, i);
        }
        printarr(arr);
        System.out.println();

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapfiy(arr, 0, i);
        }
    }

    public static void heapInset(int[] arr, int i) {
        int parent = 0;
        while (i != 0) {
            parent = (i - 1) / 2;
            if (arr[parent] < arr[i]) {
                swap(arr, i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    /**
     * 非递归排序
     */

    public static void heapfiy(int[] arr, int i, int size) {

        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int lagest = i;
        while (l < size) {
            if (arr[i] < arr[l]) {
                lagest = l;
            }
            if (r < size && arr[r] > arr[lagest]) {
                lagest = r;
            }
            if (lagest != i) {
                swap(arr, i, lagest);
            } else {
                break;
            }
            i = lagest;
            l = lagest * 2 + 1;
            r = lagest * 2 + 2;
        }

    }

    /**
     * 递归
     */

    public static void heap(int[] arr, int i, int size) {

        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int lagest = i;
        if (arr[i] < arr[l]) {
            lagest = l;
        }
        if (r < size && arr[r] > arr[lagest]) {
            lagest = r;
        }
        if (lagest != i) {
            swap(arr, i, lagest);
            heapfiy(arr, size, lagest);
        }

    }


    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 5, 3, 7, 9, 2, 4};

        printarr(arr);
        System.out.println();
        sort(arr);
        printarr(arr);

        //        printarr(arr);
//
//        swap(arr,1,2);
//
//        printarr(arr);


    }


    public static void printarr(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }


}
