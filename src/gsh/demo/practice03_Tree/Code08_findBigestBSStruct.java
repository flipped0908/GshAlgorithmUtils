package gsh.demo.practice03_Tree;

import java.util.HashMap;

/**
 * 找都二叉树种 最大的 符合搜索二叉树的 拓扑结构
 */
public class Code08_findBigestBSStruct {

    // 方法一 时间复杂度 为O（N^2）

    /**
     * 先序遍历每一个节点
     *
     * @param head
     * @return
     */
    public static int treeSize(TreeNode head) {
        if (head == null) {
            return 0;
        }
        // 先序遍历每一个节点
        int max = maxTop(head, head);
        max = Math.max(max, treeSize(head.left));
        max = Math.max(max, treeSize(head.right));
        return max;

    }

    /**
     * @param h 父节点
     * @param n 可能是自己 出现了分支 自己 左孩子和 右孩子
     * @return 符合条件的 节点的数目
     */
    public static int maxTop(TreeNode h, TreeNode n) {

        if (h != null && n != null && isTreeNode(h, n, n.value)) {
            return maxTop(h, n.left) + maxTop(h, n.right) + 1;
        }

        return 0;
    }

    /**
     * @param h     父节点
     * @param n     子节点
     * @param value 子节点的值
     * @return 如果子节点的值 小于父节点 那么 子节点应该是左孩子  如果子几点是左孩子 那么返回 true ，如果子节点不是左孩子
     * 那么返回false
     * <p>
     * <p>
     * 这个递归 把需要的参数都放入参数中 ，也就是压入栈中
     */
    public static boolean isTreeNode(TreeNode h, TreeNode n, int value) {
        if (h == null) {
            return false;
        }
        if (h == n) {
            return true;
        }

        return isTreeNode(h.value > value ? h.left : h.right, n, value);
    }


    /**
     * 方法1 总结 一顿递归操作
     * <p>
     * 先序遍历 时间复杂度 O(N)
     * <p>
     * 遍历到每一个节点的时候  又遍历了每一个节点的子树  时间复杂度为 O(N)
     * <p>
     * 总的时间复杂度为 O(N^2)
     */


    // 方法 2


    static class Record {
        public int l;
        public int r;

        public Record(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    // version 1.0

    public static Record posOrder(TreeNode head, HashMap<TreeNode, Record> map) {
        if (head == null) {
            return new Record(0, 0);
        }
        Record lr = posOrder(head.left, map);
        Record rr = posOrder(head.right, map);

        lr = modifyRecord(lr, head, map);
        return new Record(lr.l + lr.r + 1, rr.l + rr.r + 1);


    }

    public static Record modifyRecord(Record record, TreeNode node, HashMap<TreeNode, Record> map) {

        if (node.left == null) {
            return record;
        }
        TreeNode cur = node.left;
        int value = node.value;
        while (cur.right != null && cur.right.value < value) {
            cur = cur.right;
        }
        if (cur != null) {
            Record tmp = map.get(cur);
            record.r = record.r - tmp.l - tmp.r - 1;
        }
        return record;

    }


    /**
     *
     * 在 1.0 中 考虑的太简单   忽略了 左右的条件
     *
     * 还是犯了写代码的一大忌  写之前完全没有理清楚逻辑
     *
     * 这个错误只会让你的代码越写越乱
     *
     *
     */

    // version 2.0

    public static int posOrder2(TreeNode head, HashMap<TreeNode, Record> map) {
        if (head == null) {
            return 0;
        }
        int ls = posOrder2(head.left, map);
        int rs = posOrder2(head.right, map);

        modifyRecord2(head.left, head.value, map, true);
        modifyRecord2(head.right, head.value, map, false);


        Record lr = map.get(head.left);
        Record rr = map.get(head.right);

        int lsbt = lr == null ? 0 : lr.l + lr.r + 1;
        int rsbt = rr == null ? 0 : rr.l + rr.r + 1;

        map.put(head, new Record(lsbt, rsbt));
        return Math.max(lsbt + rsbt + 1, Math.max(ls, rs));

    }


    /**
     *
     * 这个方法 也是出现了分支 ，就是递归套路中，考虑可能性的第一步 ，
     *
     * 可能性要抽象出来 形成分支
     *
     * 还有就是 递归的参数 是传递的什么
     *
     * 以及返回值应该怎么确定
     *
     * 递归要把条件和结果考虑到 参数 和返回值 中
     *
     * 这些参数和返回值 都会存储到一个大的栈中作为临时 变量
     *
     *
     * 如果参数想作为全句变量 就要在第入口之外 构造一个全局变量 ，如果不是话都会成为局部变量 ，会发生变化 ， 返回值肯定是局部变量
     *
     * */

    public static int modifyRecord2(TreeNode node, int value, HashMap<TreeNode, Record> map, boolean s) {

        if (node == null || !map.containsKey(node)) {
            return 0;
        }
        Record r = map.get(node);

        if ((s && node.value > value) || (!s && node.value < value)) {
            map.remove(node);
            return r.r + r.l + 1;
        } else {
            int nums = modifyRecord2(s ? node.left : node.right, node.value, map, s);
            if (s) {
                r.r = r.r - nums;
            } else {
                r.l = r.l - nums;
            }
            map.put(node, r);
            return nums;
        }

    }


    /**
     * 总结 ：
     *
     * 其实程序设计就是一个函数 条件 输入 设计中间会用到的数据结构  最后求出返回值
     *
     * 把思想 通过程序实现
     *
     * 要经过不断的联系 才能有一定的大局观
     *
     */


}
