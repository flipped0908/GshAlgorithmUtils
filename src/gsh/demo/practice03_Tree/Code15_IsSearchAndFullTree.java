package gsh.demo.practice03_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 判断一颗二叉树是否为搜索二叉树和完全二叉树
 */
public class Code15_IsSearchAndFullTree {

    // 判断是否为搜索二叉树

    // 改写中序遍历

    public static boolean inUnReduce(TreeNode head) {

        if (head == null) {
            return true;
        }
        int pre = 0;
        int index = -1;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (index == -1) {
                    pre = head.value;
                    index = 0;
                }
                if (head.value < pre) {
                    return false;
                }
                pre = head.value;
                head = head.right;
            }
        }
        return true;
    }


    // 改写 morris 遍历

    public static void morris(TreeNode head) {

        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            if (cur.left != null) {
                mostRight = cur.left;
                while (mostRight.right != null) {
                    if (mostRight.right == cur) {

                        // 第二次到这里
                        break;
                    }
                    // 第一次到这里
                    mostRight = mostRight.right;
                }
                if (mostRight.right == cur) {
                    // 第二次到这里
                    System.out.print(cur.value + " ");

                    mostRight.right = null;
                    cur = cur.right;
                } else {
                    // 第一次到这里
                    mostRight.right = cur;
                    cur = cur.left;
                }
            } else {
                System.out.print(cur.value + " ");
                cur = cur.right;
            }

        }
    }


    // 判断是否为完全二叉树

    // 广度优先搜索

    /**
     * 1 节点有 右孩子，没有左孩子
     * 2 节点 没有孩子节点 ，后边的节点都应该没有节点
     */


    public static boolean layer(TreeNode head) {

        if (head == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(head);

        boolean flg = true;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode l = node.left;
            TreeNode r = node.right;


            if (l == null && r != null) {
                return false;
            }

            if (!flg) {
                if (l != null || r != null) {
                    return false;
                }
            }

            if (l == null || r == null) {
                flg = false;
            }

            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            }
        }

        return true;


    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(7);
        head.left = new TreeNode(6);
        head.right = new TreeNode(9);
        head.right.left = new TreeNode(8);
        head.left.left = new TreeNode(4);
        head.left.left.left = new TreeNode(3);
        head.left.left.right = new TreeNode(5);
//        morris(head);
//        System.out.println();
        System.out.println(layer(head));
    }


}
