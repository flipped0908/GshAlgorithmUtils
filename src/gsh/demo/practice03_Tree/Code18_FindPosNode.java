package gsh.demo.practice03_Tree;

/**
 * 在二叉树种找到一个节点的后继节点
 * 中序遍历
 */

public class Code18_FindPosNode {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 找到根节点 中心遍历  时间复杂度O(N) 空间复杂度O(N)
     * <p>
     * 优化的算法 时间复杂度 O(L) 空间复杂度O(1)
     */


    public static Node getNext(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return getMostLeft(node.right);
        }
        Node parent = node.parent;
        while (parent != null && parent.left != node) {
            node = parent;
            parent = node.parent;
        }
        return parent;


    }

    public static Node getMostLeft(Node node) {
        if (node == null) {
            return null;
        }
        while (node != null) {
            node = node.left;
        }
        return node;
    }


}
