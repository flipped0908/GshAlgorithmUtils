package gsh.demo.practice03_Tree;

import gsh.utils.MyError;

import java.util.LinkedList;

public class TreeUtils {


    /**
     * 生成完全二叉树  按照广度优先的原则
     *
     * @param arr
     * @return
     */
    public static TreeNode createBinaryTree(int[] arr) {

        if (arr == null || arr.length == 0) {
            throw new RuntimeException("create tree is empty");
        }

        TreeNode head = new TreeNode(arr[0]);

        LinkedList<TreeNode> queue = new LinkedList<>();

        int size = arr.length - 1;

        int index = 1;

        queue.addLast(head);

        boolean isLeft = true;

        TreeNode node = null;
        int nodechilders = 0;

        while (size > 0 && !queue.isEmpty()) {
            if (nodechilders == 0) {
                node = queue.pollFirst();
            }
            if (isLeft) {
                TreeNode nodel = new TreeNode(arr[index++]);
                node.left = nodel;
                queue.addLast(nodel);
                isLeft = false;
                nodechilders = 1;
            } else {
                TreeNode noder = new TreeNode(arr[index++]);
                node.right = noder;
                queue.addLast(noder);
                isLeft = true;
                nodechilders = 0;
            }
            size--;
        }

        return head;

    }

    /**
     * 获取完全二叉树的高度
     *
     * @param head
     * @return
     */
    public static int getTreeLayer(TreeNode head) {
        if (head == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int layer = 1;
        int cnt = 1;
        int cntdel = cnt;
        queue.addLast(head);
        while (!queue.isEmpty()) {

            TreeNode node = queue.pollFirst();
            cntdel--;
            if (cntdel == 0) {
                cnt *= 2;
                cntdel = cnt;
                layer++;
            }

            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }

        }
        return layer;
    }

    /**
     * 打印完全二叉树
     */
    public static void printTree(TreeNode head) {
        int layer = getTreeLayer(head);
        int num = 1;
        for (int i = 0; i < layer; i++) {
            num *= 2;
        }
        int lastnum = num * 3 - 1;

        LinkedList<TreeNode> queue = getTreeNodes(head);

        TreeNode n1 = queue.pollFirst();
        printkong(lastnum / 2);
        System.out.print(n1.value);
        System.out.println();
        int everynum = 1;
        for (int i = 1; i < layer; i++) {
            everynum = everynum * 2;
            num = everynum;
            int tmp = (lastnum - num) / (num + 1);
            printkong(tmp);
            while (num > 0) {
                if (queue.isEmpty()) {
                    return;
                }
                TreeNode node = queue.pollFirst();
                System.out.print(node.value);
                printkong(tmp);
                num--;
            }
            System.out.println();
            System.out.println();

        }

    }

    private static void printkong(int n) {
        while (n > 0) {
            System.out.print(" ");
            n--;
        }
    }

    private static LinkedList<TreeNode> getTreeNodes(TreeNode head) {
        if (head == null) {
            return new LinkedList<>();
        }
        LinkedList<TreeNode> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(head);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            res.addLast(node);
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }

        }
        return res;
    }


    public static void printnodevalue(TreeNode node) {
        if (node == null) {
            MyError.myerror(" treenode is null , can not find value");
        }
        System.out.print(node.value + "  ");
    }

}
