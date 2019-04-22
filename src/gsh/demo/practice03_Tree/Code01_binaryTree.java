package gsh.demo.practice03_Tree;


import org.omg.CORBA.NO_IMPLEMENT;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 分别用递归和非递归方法实现二叉树的先序中序和后续遍历
 */

public class Code01_binaryTree {

    // 先序

    public static void preOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + "  ");
        preOrder(head.left);
        preOrder(head.right);
    }

    public static void pre(TreeNode head) {
        if (head == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(head);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.value + "  ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

    }

    // 中序

    public static void inOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.print(head.value + "  ");
        inOrder(head.right);
    }

    public static void in(TreeNode head) {
        if (head == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(head);

        while (!stack.isEmpty()) {
            while (head.left != null) {
                stack.push(head.left);
                head = head.left;
            }
            while (head.right == null && !stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + "  ");
            }

            if (head.right != null) {
                stack.push(head.right);
                head = head.right;
            }

        }

    }


    // 后序

    public static void posOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        posOrder(head.left);
        posOrder(head.right);
        System.out.print(head.value + "  ");

    }

    public static void pos(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            stack2.push(node);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }

        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().value+"  ");
        }
    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        TreeNode head = TreeUtils.createBinaryTree(arr);

        TreeUtils.printTree(head);

        System.out.println();
//        preOrder(head);
//        System.out.println();
//        pre(head);
//        System.out.println();
//        inOrder(head);
//        System.out.println();
//        in(head);
        posOrder(head);
        System.out.println();
        pos(head);


    }

    private static int stackdeep = 0;


    public static void preOrder1(TreeNode head) {
        System.out.println("stackdee:" + stackdeep);
        stackdeep++;
        if (head == null) {
            stackdeep--;
            return;
        }
        preOrder1(head.left);
        preOrder1(head.right);
    }


}
