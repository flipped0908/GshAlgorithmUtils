package gsh.zuocom.heap;

import gsh.utils.MyError;

public class MyHeap {

    public int[] heaparr;

    public int index;

    public int size;

    public MyHeap(int size) {
        index = 0;
        this.size = size;
        heaparr = new int[size];
    }

    public void insert(int num) {
        if ((index + 1) >= size) {
            MyError.myerror(" heap is full");
        }
        heaparr[index + 1] = num;
        int tmp = index;
        while (num < heaparr[tmp]) {
            tmp--;
        }
        swap(tmp, index);
    }

    public void swap(int a, int b) {
        if (a >= size || b >= size) {
            MyError.myerror(" out of max size");
        }
        heaparr[a] = heaparr[a] ^ heaparr[b];
        heaparr[b] = heaparr[a] ^ heaparr[b];
        heaparr[a] = heaparr[a] ^ heaparr[b];
    }





}
