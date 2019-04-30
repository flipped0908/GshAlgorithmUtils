package gsh.zuocom.sort;

public class quicksort {


    public static void quicksotr(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int) (Math.random() * (l - r + 1)), r);
            int[] tmp = partitin(arr, l, r);
            quicksotr(arr, l, tmp[0] - 1);
            quicksotr(arr, tmp[1] + 1, r);
        }
    }


    public static int[] partitin(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;

        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, l, --more);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
