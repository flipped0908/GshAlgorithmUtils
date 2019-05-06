package gsh.demo.practice03_Tree;

/**
 * 二叉树节点间最大距离问题
 * <p>
 * 二叉树节点N 时间复杂度 为 O(N)
 */
public class Code20_nodeLogestInstance {
    public class ReturnType {
        public int maxDistance;
        public int height;

        public ReturnType(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    public ReturnType process(TreeNode head) {
        if (head == null) {
            return new ReturnType(0, 0);
        }
        ReturnType lr = process(head.left);
        ReturnType rr = process(head.right);
        return new ReturnType(Math.max(Math.max(lr.maxDistance, rr.maxDistance),
                (lr.height + rr.height + 1)), Math.max(lr.height, rr.height) + 1);
    }


}
