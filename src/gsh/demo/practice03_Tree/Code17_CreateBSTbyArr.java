package gsh.demo.practice03_Tree;


/**
 * 通过有序数组生成平衡搜索二叉树
 */

public class Code17_CreateBSTbyArr {

    public static TreeNode creat(int[] arr, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(arr[mid]);

        node.left = creat(arr, start, mid - 1);
        node.right = creat(arr, mid+1, end);

        return node;

    }

}
