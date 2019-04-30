package gsh.zuocom.sort;

import java.sql.Array;

public class mergesort {


    public static void mergesort(int[] arr, int l, int r) {

        if (l == r) {
            return;
        }
        int mid = l + (r - l) >> 1;

        mergesort(arr, l, mid);
        mergesort(arr, mid + 1, r);

        merge(arr, l, mid, r);

    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int[] arr1 = new int[mid - l + 1];
        int[] arr2 = new int[r - mid];
        System.arraycopy(arr, mid + 1, arr2, 0, r - mid);
    }


    public static int[] merge(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int index = 0;
        int a1 = 0;
        int a2 = 0;
        while (a1 < arr1.length && a2 < arr2.length) {
            if (arr1[a1] <= arr2[a2]) {
                res[index++] = arr1[a1++];
            } else {
                res[index++] = arr2[a2++];
            }
        }
        while (a1 < arr1.length) {
            res[index++] = arr1[a1++];

        }
        while (a2 < arr2.length) {
            res[index++] = arr2[a2++];
        }
        return res;
    }

}
