package gsh.demo.practice03_Tree;


import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树 按 层打印 和 按Z打印
 */
public class Code09_printBTZigZag {


    public static void printByLayer(TreeNode head) {

        if (head == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> queuenext = new LinkedList<>();
        queue.addLast(head);
        boolean isNext = false;
        while (!queue.isEmpty() || !queuenext.isEmpty()) {
            if (!isNext) {
                help(queue,queuenext);
                if (queue.isEmpty()) {
                    System.out.println();
                    isNext = true;
                }
            } else {
                help(queuenext,queue);
                if (queuenext.isEmpty()) {
                    System.out.println();
                    isNext = false;
                }
            }
        }
    }

    public static void printByZ(TreeNode head) {

        if (head == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> queuenext = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.addLast(head);
        boolean isNext = false;
        while (!queue.isEmpty() || !queuenext.isEmpty()) {
            if (!isNext) {
                help(queue,queuenext);
                if (queue.isEmpty()) {
                    System.out.println();
                    isNext = true;
                }
            } else {
                TreeNode n1 = queuenext.pollFirst();
                stack.push(n1);
                if (n1.left != null) {
                    queue.addLast(n1.left);
                }
                if (n1.right != null) {
                    queue.addLast(n1.right);
                }
                if (queuenext.isEmpty()) {
                    while (!stack.isEmpty()){
                        TreeNode n2 = stack.pop();
                        System.out.print(n2.value + " ");
                    }
                    System.out.println();
                    isNext = false;
                }
            }
        }
    }



    public static void help(LinkedList<TreeNode> queue,LinkedList<TreeNode> queue2) {
        TreeNode n1 = queue.pollFirst();
        System.out.print(n1.value + " ");
        if (n1.left != null) {
            queue2.addLast(n1.left);
        }
        if (n1.right != null) {
            queue2.addLast(n1.right);
        }
    }



    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        TreeNode head = TreeUtils.createBinaryTree(arr);

        printByZ(head);




    }




}
