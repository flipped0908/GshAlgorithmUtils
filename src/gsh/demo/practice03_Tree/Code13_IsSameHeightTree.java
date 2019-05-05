package gsh.demo.practice03_Tree;

/**
 * 判断 二叉树 是否是 平衡 二叉树
 */

public class Code13_IsSameHeightTree {

    /**
     * 就是判断左子树的高度 和右子树的高度
     * <p>
     * <p>
     * 可能性
     * 1： x 左不平衡
     * 2： x 右不平衡
     * 3： x 加 左 和 右 不平衡
     * 4： 平衡
     */


    public static class ReturnType {
        public boolean isBalance;
        public int height;

        public ReturnType(boolean isBalance, int height) {
            this.height = height;
            this.isBalance = isBalance;
        }
    }


    public static ReturnType process(TreeNode head) {
        if (head == null) {
            return new ReturnType(true, 0);
        }
        ReturnType lr = process(head.left);
        ReturnType rr = process(head.right);
        return new ReturnType(lr.isBalance && rr.isBalance && (Math.abs(lr.height - rr.height) <= 1)
                , Math.max(lr.height, rr.height));
    }


}
