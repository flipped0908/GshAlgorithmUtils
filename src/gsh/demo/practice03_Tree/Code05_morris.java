package gsh.demo.practice03_Tree;

/**
 * 遍历二叉树的神级方法
 */

public class Code05_morris {


    public static void morris(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode mostRight = cur.left;
                while (mostRight.right != null) {
                    if (mostRight.right == cur) {
                        break;
                    }
                    mostRight = mostRight.right;

                }
                if (mostRight.right == cur) {
                    mostRight.right = null;
                    cur = cur.right;
                } else {
                    mostRight.right = cur;
                    cur = cur.left;
                }
            }
        }

    }


    public static void morrispre(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        while (cur != null) {
            if (cur.left == null) {
                TreeUtils.printnodevalue(cur);
                cur = cur.right;
            } else {
                TreeNode mostRight = cur.left;
                while (mostRight.right != null) {
                    if (mostRight.right == cur) {
                        break;
                    }
                    mostRight = mostRight.right;
                }
                if (mostRight.right == cur) {
                    mostRight.right = null;
                    cur = cur.right;
                } else {
                    mostRight.right = cur;
                    TreeUtils.printnodevalue(cur);
                    cur = cur.left;
                }
            }
        }

    }

    public static void morrisin(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        while (cur != null) {
            if (cur.left == null) {
                TreeUtils.printnodevalue(cur);
                cur = cur.right;
            } else {
                TreeNode mostRight = cur.left;
                while (mostRight.right != null) {
                    if (mostRight.right == cur) {
                        break;
                    }
                    mostRight = mostRight.right;
                }
                if (mostRight.right == cur) {
                    mostRight.right = null;
                    TreeUtils.printnodevalue(cur);
                    cur = cur.right;
                } else {
                    mostRight.right = cur;
                    cur = cur.left;
                }
            }
        }

    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        TreeNode head = TreeUtils.createBinaryTree(arr);

        TreeUtils.printTree(head);

        System.out.println();

        morrispre(head);
        System.out.println();
        morrisin(head);

    }


}
