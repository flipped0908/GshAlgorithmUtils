package gsh.gdemo.tree;


/**
 * 树形动态规划
 * <p>
 * Q1: 二叉树节点间最大距离问题
 * <p>
 * Q2: 找到二叉树种最大搜索二叉子树
 */

public class TreeDp {

    // Q1

    public static class ReturnType {
        public int maxDistance;
        public int height;

        public ReturnType(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    public ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(0, 0);
        }

        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);
        int maxd = Math.max(Math.max(leftData.maxDistance, rightData.maxDistance),
                leftData.height + rightData.height + 1);
        return new ReturnType(maxd, Math.max(leftData.height, rightData.height) + 1);

    }


    // Q2


    // 总结：利用递归 中间过程的信息 在返会的时候 加盐  局可以处理成你想要的结果 也是迭代。


    // 类似于树的问题基本上是递归


}
