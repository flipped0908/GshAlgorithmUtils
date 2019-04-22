package gsh.demo.practice03_Tree;

import java.util.Stack;

/**
 * 打印二叉树的边界
 * <p>
 * 标准一 头结点为边界 叶为边界 节点在最左层或者最右层也是边界
 * 标准二 左边延伸下去的是左边界，右边延伸下去的是右边界
 * <p>
 * 时间复杂度为O（N） 空间复杂度为O(h) h为树的高度
 */
public class Code02_printBinaryTreeBorder {


    /**
     * version 1.0  发现 到 while 循环里边 分支太多，而且还需要回溯， 一个last变量不够 所以可能需要一个栈
     * <p>
     * 考虑到回溯 想用递归的方法 可是 时间复杂度 要求 O(N) 递归应该是不行的
     */
    public static void print(TreeNode head) {

        if (head == null) {
            return;
        }

        System.out.println(head.value);

        int h = 1;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode l = head.left;
        TreeNode r = head.right;
        TreeNode last = null;
        while (l != null) {
            System.out.println(l.value);
            if (l.left != null && l.right == null) {
                l = l.left;
            }
            if (l.left == null && l.right != null) {
                l = l.right;
            }
            if (l.left != null && l.right != null) {

            }
            if (l.left == null && l.right == null) {

            }
        }

    }


    /**
     *  version 2.0
     */

    /**
     * 1 得到每一层最左 最右的节点
     */


    public static void print2(TreeNode head) {
        if (head == null) {
            return;
        }
        int height = getHeight(head, 0);
        TreeNode[][] edgeMap = new TreeNode[height][2];

        setEdge(head, 0, edgeMap);

        // 打印左边界
        for (int i = 0; i < edgeMap.length; i++) {
            System.out.print(edgeMap[i][0].value + "  ");
        }
        // 打印底
        preleft(head, 0, edgeMap);

        // 打印右边界
        for (int i = edgeMap.length - 1; i > -1; i--) {
            if (edgeMap[i][0] != edgeMap[i][1]) {
                System.out.print(edgeMap[i][1].value + "  ");
            }
        }

    }

    public static void preleft(TreeNode node, int l, TreeNode[][] m) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && node != m[l][0] && node != m[l][1]) {
            System.out.print(node.value + "  ");
        }
        preleft(node.left, l+1, m);
        preleft(node.right, l+1, m);

    }

    public static int getHeight(TreeNode head, int l) {
        if (head == null) {
            return l;
        }
        return Math.max(getHeight(head.left, l + 1), getHeight(head.right, l + 1));
    }

    public static void setEdge(TreeNode node, int layer, TreeNode[][] edgeMap) {
        if (node == null) {
            return;
        }
        edgeMap[layer][0] = edgeMap[layer][0] == null ? node : edgeMap[layer][0];
        edgeMap[layer][1] = node;
        setEdge(node.left, layer + 1, edgeMap);
        setEdge(node.right, layer + 1, edgeMap);
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.right.left = new TreeNode(7);
        head.left.right.right = new TreeNode(8);
        head.left.right.right.right = new TreeNode(11);
        head.left.right.right.right.left = new TreeNode(13);
        head.left.right.right.right.right = new TreeNode(14);

        head.right = new TreeNode(3);
        head.right.right = new TreeNode(6);
        head.right.left = new TreeNode(5);
        head.right.left.right = new TreeNode(10);
        head.right.left.left = new TreeNode(9);
        head.right.left.left.left = new TreeNode(12);
        head.right.left.left.left.left = new TreeNode(15);
        head.right.left.left.left.right = new TreeNode(16);


        print2(head);
    }


}
