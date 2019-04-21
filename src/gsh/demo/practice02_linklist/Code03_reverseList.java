package gsh.demo.practice02_linklist;

public class Code03_reverseList {

    // 翻转单链表

    public static GSHSingleNode reverseS(GSHSingleNode head) {

        if (head == null) {
            return null;
        }

        GSHSingleNode cur = head;
        GSHSingleNode pre = null;
        while (cur != null) {
            GSHSingleNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }


    // 翻转单链表

    public static GSHDoubleNode reverseD(GSHDoubleNode head) {

        if (head == null) {
            return null;
        }

        GSHDoubleNode cur = head;
        GSHDoubleNode pre = null;
        while (cur != null) {
            GSHDoubleNode next = cur.next;
            cur.next = pre;
            cur.pre = next;
            pre = cur;
            cur = next;
        }

        return pre;
    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        GSHLinkUtils.printDoubleList(reverseD(GSHLinkUtils.getDoubleList(arr)));

    }


}
