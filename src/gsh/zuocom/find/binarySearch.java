package gsh.zuocom.find;

public class binarySearch {


    public static int find(int[] arr, int l, int r, int key) {
        if (l > r) {
            return -1;
        }
        int mid = (l + r) >> 1;
        if (arr[mid] > key) {
            r = mid - 1;
        } else if (arr[mid] < key) {
            l = mid + 1;
        } else {
            return mid;
        }
        return find(arr, l, r, key);
    }


}
