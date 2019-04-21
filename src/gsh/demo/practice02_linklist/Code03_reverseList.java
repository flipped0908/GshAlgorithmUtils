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


    // 翻转部分单链表

    public static GSHSingleNode reverseSPart(GSHSingleNode head, int from, int to) {

        if (head == null || from >= to || GSHLinkUtils.sizeS(head) < to) {
            throw new RuntimeException(" args is wrong");
        }

        GSHSingleNode cur = head;
        GSHSingleNode pre = null;

        GSHSingleNode oStart = null;
        GSHSingleNode oEnd = null;
        GSHSingleNode nStart = null;
        GSHSingleNode nEnd = null;
        int index = 1;
        while (cur != null) {
            if (from == 1) {
                oStart = null;
            }
            if (from > 1 && index == from - 1) {
                oStart = cur;
            }
            if (index == from) {
                nStart = cur;
            }
            if (index == to + 1) {
                oEnd = cur;
                break;
            }
            if (index >= from && index <= to) {
                GSHSingleNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            } else {
                cur = cur.next;
            }
            if (index == to) {
                nEnd = pre;
            }

            index++;
        }


        if (oStart == null) {
            head = nEnd;
        } else {
            oStart.next = nEnd;
        }
        nStart.next = oEnd;

        return head;

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

        int[] arr = {1, 2, 3, 4, 5, 6};

        GSHLinkUtils.printList(reverseSPart(GSHLinkUtils.getList(arr), 1, 6));


        // GSHLinkUtils.printDoubleList(reverseD(GSHLinkUtils.getDoubleList(arr)));

    }


}
