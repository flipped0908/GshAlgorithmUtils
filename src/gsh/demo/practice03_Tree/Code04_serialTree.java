package gsh.demo.practice03_Tree;

import java.security.PublicKey;
import java.util.LinkedList;
import java.util.Queue;

public class Code04_serialTree {

    public static String serialBypre(TreeNode head) {
        if (head == null) {
            return "#!";
        }
        String res = String.valueOf(head.value) + "!";
        res += serialBypre(head.left);
        res += serialBypre(head.right);
        return res;


    }

    public static TreeNode conSerialByStrig(String str) {

        String[] arr = str.split("!");
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }

        return reSailPre(queue);
    }


    public static TreeNode reSailPre(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = reSailPre(queue);
        node.right = reSailPre(queue);
        return node;

    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        TreeNode head = TreeUtils.createBinaryTree(arr);

        TreeUtils.printTree(head);

        System.out.println();

        System.out.println();

        TreeUtils.printTree(conSerialByStrig(serialBypre(head)));

    }


}
