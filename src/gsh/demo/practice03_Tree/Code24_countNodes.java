package gsh.demo.practice03_Tree;

/**
 * 统计完全二叉树节点的个数
 * <p>
 * 要求 时间复杂度小于 O（N）
 */
public class Code24_countNodes {


    public static int mostLeftLevel(TreeNode node, int leve) {
        while (node != null) {
            node = node.left;
            leve++;
        }
        return leve - 1;
    }

    public static int bs(TreeNode node, int l, int h) {
        if (l == h) {
            return l;
        }
        if (mostLeftLevel(node.left, l + 1) == h) {
            return (1 << (h - l)) + bs(node.right, l + 1, h);
        } else {
            return (1 << (h - l - 1)) + bs(node.left, l + 1, h);
        }

    }


}
