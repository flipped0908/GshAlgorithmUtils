package gsh.gdemo.link;


/**
 * 单向链表
 * <p>
 * 循环链表
 * <p>
 * 链表的删除，插入
 * <p>
 * 反转
 */

public class ReverseLink {


    public static Node reverse(Node head) {
        if (head == null) {
            return null;
        }

        Node pre, cur, next;
        pre = null;
        cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        Node hed = getList(arr);

        printList(reverse(hed));


    }




    public static Node getList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            cur.next = node;
            cur = node;

        }
        return head;
    }


    public static void printList(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (cur != null) {
            System.out.print(" " + cur.value + " -> ");
            cur = cur.next;
        }
        System.out.print(" null");
        System.out.println();
    }



}
