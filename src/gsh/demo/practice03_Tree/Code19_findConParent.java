package gsh.demo.practice03_Tree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 在二叉树中找到两个节点最近的公共祖先
 * <p>
 * 进阶问题： 如果查询两个节点最近的公共祖先操作十分频繁，想法让单条查询的查询时间减少
 * <p>
 * 再进阶问题： 给定二叉树的头结点head，同时给定所有想要进行的查询，二叉树的节点数量为N，查询条数为M
 * 请在时间复杂度为O(M+N) 内返回所有查询的结果
 */
public class Code19_findConParent {

    public static TreeNode find(TreeNode head, TreeNode n1, TreeNode n2) {

        if (head == null || head == n1 || head == n2) {
            return head;
        }
        TreeNode l = find(head.left, n1, n2);
        TreeNode r = find(head.right, n1, n2);
        if (l != null && r != null) {
            return head;
        }
        return l != null ? l : r;
    }


    // 构建一个kV  k:节点  V:节点的祖先

    public class Record1 {

        // 每个节点只有一个祖先

        private HashMap<TreeNode, TreeNode> map;

        public Record1(TreeNode node) {
            map = new HashMap<>();
            if (node != null) {
                map.put(node, null);
            }
        }

        public void setMap(TreeNode head) {
            if (head == null) {
                return;
            }
            if (head.left != null) {
                map.put(head.left, head);
            }
            if (head.right != null) {
                map.put(head.right, head);
            }
            setMap(head.left);
            setMap(head.right);
        }

        public TreeNode query(TreeNode n1, TreeNode n2) {

            HashSet<TreeNode> path = new HashSet<>();

            // 把 n1 的祖先放在 set中
            while (map.containsKey(n1)) {
                path.add(n1);
                n1 = map.get(n1);
            }

            // 开始找n2 的祖先 遇到相同的就返回
            while (!path.contains(n2)) {
                n2 = map.get(n2);
            }
            return n2;
        }


    }


    // 直接建立任意两个节点之间 最近公共祖先的记录

    public class Record2 {

        private HashMap<TreeNode, HashMap<TreeNode, TreeNode>> map;

        public Record2(TreeNode head) {
            map = new HashMap<>();
            initMap(head);
            setMap(head);

        }

        public void initMap(TreeNode head) {
            if (head == null) {
                return;
            }
            map.put(head, new HashMap<TreeNode, TreeNode>());
            initMap(head.left);
            initMap(head.right);
        }

        private void setMap(TreeNode head) {
            if (head == null) {
                return;
            }

            headRecord(head.left, head);
            headRecord(head.right, head);
            subRecord(head);
            setMap(head.left);
            setMap(head.right);

        }

        private void headRecord(TreeNode n1, TreeNode n2) {
            if (n1 == null) {
                return;
            }
            map.get(n1).put(n2, n2);
            headRecord(n1.left, n2);
            headRecord(n1.right, n2);
        }


        private void subRecord(TreeNode head) {
            if (head == null) {
                return;
            }
            preLeft(head.left, head.right, head);
            subRecord(head.left);
            subRecord(head.right);
        }

        private void preLeft(TreeNode l, TreeNode r, TreeNode n) {
            if (l == null) {
                return;
            }
            preRigth(l, r, n);
            preLeft(l.left, r, n);
            preLeft(l.right, r, n);
        }


        private void preRigth(TreeNode l, TreeNode r, TreeNode n) {
            if (r == null) {
                return;
            }
            map.get(l).put(r, n);
            preRigth(l, r.right, n);
            preRigth(l, r.left, n);


        }

        public TreeNode query(TreeNode n1, TreeNode n2) {
            if (n1 == n2) {
                return n1;
            }
            if (map.containsKey(n1)) {
                return map.get(n1).get(n2);
            }
            if (map.containsKey(n2)) {
                return map.get(n2).get(n1);
            }
            return null;


        }


    }


}
