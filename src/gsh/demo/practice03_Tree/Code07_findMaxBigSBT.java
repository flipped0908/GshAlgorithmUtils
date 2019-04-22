package gsh.demo.practice03_Tree;

/**
 * 找到二叉树中的最大搜做二叉子树
 */
public class Code07_findMaxBigSBT {

    // one 列出可能性  以 x 为 头节点  1 在左边  2 在右边 3 包含x

    // two 整理返回值类型

    public static class ReturnType {
        public TreeNode maxBSTHead;
        public int maxBSTSize;
        public int min;
        public int max;

        public ReturnType(TreeNode maxBSTHead, int maxBSTSize, int max, int min) {
            this.maxBSTHead = maxBSTHead;
            this.maxBSTSize = maxBSTSize;
            this.max = max;
            this.min = min;
        }
    }

    // three 构造递归函数

    public static ReturnType process(TreeNode head) {
        //base case 1 子树为空  2 最小值为系统最大 3 最大值为系统最小

        if (head == null) {
            return new ReturnType(head, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        ReturnType rl = process(head.left);
        ReturnType rr = process(head.right);

        int max = Math.max(head.value, Math.max(rl.max, rr.max));

        int min = Math.min(head.value, Math.min(rr.min, rl.min));

        if (rl.max <= head.value && rr.min >= head.value) {
            return new ReturnType(head, rl.maxBSTSize + rr.maxBSTSize + 1, rr.max, rl.min);
        } else {

            return rr.maxBSTSize > rl.maxBSTSize ? new ReturnType(rr.maxBSTHead, rr.maxBSTSize, max, min) :
                    new ReturnType(rl.maxBSTHead, rl.maxBSTSize, max, min);
        }


    }


}
