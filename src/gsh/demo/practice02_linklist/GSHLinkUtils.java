package gsh.demo.practice02_linklist;

public class GSHLinkUtils {


    public static boolean hasNext(GSHSingleNode node) {
        if (node.next == null) {
            return false;
        }
        return true;
    }


    public static GSHSingleNode getList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        GSHSingleNode head = new GSHSingleNode(arr[0]);
        GSHSingleNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            GSHSingleNode node = new GSHSingleNode(arr[i]);
            cur.next = node;
            cur = node;

        }
        return head;
    }


    public static void printList(GSHSingleNode head) {
        if (head == null) {
            return;
        }
        GSHSingleNode cur = head;
        while (cur != null) {
            System.out.print(" " + cur.value + " -> ");
            cur = cur.next;
        }
        System.out.print(" null");
        System.out.println();
    }


    public static GSHDoubleNode getDoubleList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        GSHDoubleNode head = new GSHDoubleNode(arr[0]);
        head.pre = null;
        head.next = null;
        GSHDoubleNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            GSHDoubleNode node = new GSHDoubleNode(arr[i]);
            cur.next = node;
            node.pre = cur;
            cur = node;

        }
        return head;
    }


    public static void printDoubleList(GSHDoubleNode head) {
        if (head == null) {
            return;
        }
        GSHDoubleNode cur = head;
        while (cur != null) {
            System.out.print(" " + cur.value + " -> ");
            cur = cur.next;
        }
        System.out.print(" null");
        System.out.println();
    }


    public static int sizeS(GSHSingleNode node) {
        if (node == null) {
            return 0;
        }
        int size = 1;
        while (node.next != null) {
            node = node.next;
            size++;
        }
        return size;
    }


    public static GSHSingleNode getCircleList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        GSHSingleNode head = new GSHSingleNode(arr[0]);
        GSHSingleNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            GSHSingleNode node = new GSHSingleNode(arr[i]);
            cur.next = node;
            cur = node;
        }

        cur.next = head;

        return head;
    }


    public static void printCircleList(GSHSingleNode head) {
        if (head == null) {
            return;
        }
        GSHSingleNode cur = head;
        while (cur != null) {
            System.out.print(" " + cur.value + " -> ");
            if (cur.next == head) {
                System.out.print(" " + head.value + " -> ");
                break;
            }
            cur = cur.next;

        }
        System.out.print(" circle end ");
        System.out.println();
    }


    public static GSHSingleNode reverse(GSHSingleNode head ,int from ,int to){
        return Code03_reverseList.reverseSPart(head,from,to);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        printCircleList(getCircleList(arr));
    }


}
