package gsh.demo.practice01_stackandqueue;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 数组中有重复的数字  单调栈 （升级）
 */


public class Code08_OnlyUpStack01 {


    public static class Node {

        public LinkedList<Integer> indexList;
        public int value;

        public Node(int index, int value) {
            this.indexList = new LinkedList<>();
            this.value = value;
            indexList.add(index);
        }

        public void addIndex(int index) {
            indexList.add(index);
        }


    }


    public static int[][] getRightWay(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int[][] res = new int[arr.length][2];

        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (stack.isEmpty()) {
                stack.push(new Node(i, arr[i]));
                continue;
            }

            if (stack.peek().value < arr[i]) {
                stack.push(new Node(i, arr[i]));
                continue;
            }


            if (stack.peek().value == arr[i]) {
                Node node1 = stack.peek();
                node1.indexList.add(i);
                continue;
            }

            while (!stack.isEmpty() && stack.peek().value > arr[i]) {
                Node node1 = stack.pop();
                while (!node1.indexList.isEmpty()) {
                    int k = node1.indexList.pop();
                    res[k][1] = i;
                    res[k][0] = stack.isEmpty() ? -1 : stack.peek().indexList.peekLast();
                }
            }

            stack.push(new Node(i, arr[i]));

        }

        while (!stack.isEmpty()) {
            Node node1 = stack.pop();
            while (!node1.indexList.isEmpty()) {
                int k = node1.indexList.pop();
                res[k][1] = -1;
                res[k][0] = stack.isEmpty() ? -1 : stack.peek().indexList.peekLast();
            }
        }

        return res;

    }


    public static void main(String[] args) {

        //int[] arr = {3, 4, 1, 5, 6, 6, 6, 2, 7, 7, 7};

        int[] arr = { 4, 3, 2, 5, 6};


        int[][] res = getRightWay(arr);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + "  ");
            }
            System.out.println();
        }

    }

}
