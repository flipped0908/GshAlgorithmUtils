package gsh.demo.practice03_Tree;


import java.util.LinkedList;
import java.util.Stack;

/**
 * 一颗搜索二叉树中的两个节点交换了 位置 找到这两个节点
 */

public class Code10_findTwoNode {


    public static void find(TreeNode head, LinkedList<Integer> list, int[] arr) {

        if (head == null) {
            return;
        }
        find(head.left, list, arr);
        if (list.peekFirst() != null) {
            int pre = list.peekLast();
            if (pre > head.value) {
                if (arr[2] == 0) {
                    arr[0] = pre;
                    arr[2] = 1;
                } else if (arr[2] == 1) {
                    arr[1] = head.value;
                    return;
                }
            }
        }
        list.addLast(head.value);
        System.out.print(head.value + " ");
        find(head.right, list, arr);
    }


    public static int[] find1(TreeNode head) {

        if (head == null) {
            return null;
        }
        int[] arr = new int[2];

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
        return arr;
    }


    public static int[] find2(TreeNode head) {

        if (head == null) {
            return null;
        }
        int[] arr = new int[2];

        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            while (head.left != null) {
                stack.push(head);
                head = head.left;
            }
            head = stack.pop();
            System.out.print(head.value + " ");
            if (head.right != null) {
                stack.push(head.right);
                head = head.right;
            }
        }
        return arr;
    }


    // find1 和 find2 的 非递归中序遍历都错了


    public static TreeNode[] find3(TreeNode head) {

        if (head == null) {
            return null;
        }
        TreeNode[] res = new TreeNode[2];
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                TreeNode node = stack.pop();
                //System.out.print(node.value + " ");
                if (pre != null) {
                    if (pre.value > node.value) {
                        res[0] = res[0] == null ? pre : res[0];
                        res[1] = node;
                    }
                }
                pre = node;
                head = node.right;
            }
        }
        return res;
    }


    public static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) {

        //    int[] arr = {4, 2, 6, 1, 3, 5, 7};

        int[] arr = {4, 2, 6, 1, 3, 5, 7};


        TreeNode head = TreeUtils.createBinaryTree(arr);

        find3(head);
        System.out.println();


//        head = new TreeNode(5);
//        head.left = new TreeNode(4);
//        head.right = new TreeNode(6);
//        head.left.left = new TreeNode(3);
//        head.left.left.right = new TreeNode(2);
//        head.left.left.right.right = new TreeNode(2);
//
//
//        int[] arrres = find2(head);
//        System.out.println();
//        inOrder(head);
//
//        System.out.println();
//        for (int a : arrres) {
//            System.out.println(a);
//        }


    }


}
