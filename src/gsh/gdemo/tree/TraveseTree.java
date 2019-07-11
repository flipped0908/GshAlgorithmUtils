package gsh.gdemo.tree;

import java.util.Stack;

public class TraveseTree {

    /**
     * 先序 中序 后序
     * <p>
     * 非递归
     */


    public static void preOrder(Node head) {

        if (head == null) {
            return;
        }
        System.out.print(head.value + "  ");
        preOrder(head.left);
        preOrder(head.right);

    }


    /**
     * wrong
     */
    public static void unReduceInOrder1(Node head) {
        /**
         *
         * 迭代  使用栈来存放
         *
         * 使用了其他辅助的数据结构
         */

        if (head == null) {
            return;
        }
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            while (cur.left != null) {
                stack.push(cur);
                cur = cur.left;
            }
            System.out.print(stack.pop().value + "  ");
            if (!stack.isEmpty() && stack.peek().right != null) {
                stack.push(stack.peek().right);
            }
        }
    }


    // 又一次成功的失败给了这个中序的非递归遍历
    // 又是老毛病 上来就写代码 没有思考清楚写什么 结果修修补补 还是弄了个死循环




    public static void unReduceInOrder(Node head) {
        /**
         *
         * 迭代  使用栈来存放
         *
         * 使用了其他辅助的数据结构
         */

        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.value);
                head = head.right;
            }

        }
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.left.right = new Node(5);
        head.left.left = new Node(4);
//        head.left.right.right = new Node(8);
//        head.left.right.right.right = new Node(11);
//        head.left.right.right.right.left = new Node(13);
//        head.left.right.right.right.right = new Node(14);

        head.right = new Node(3);
        head.right.right = new Node(7);
        head.right.left = new Node(6);
//        head.right.left.right = new Node(10);
//        head.right.left.left = new Node(9);
//        head.right.left.left.left = new Node(12);
//        head.right.left.left.left.left = new Node(15);
//        head.right.left.left.left.right = new Node(16);


        unReduceInOrder(head);
    }


}
