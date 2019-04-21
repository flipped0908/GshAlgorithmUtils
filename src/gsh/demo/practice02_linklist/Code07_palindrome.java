package gsh.demo.practice02_linklist;

import java.util.Stack;

/**
 * 判断一个链表是否是 回文结构
 */

public class Code07_palindrome {

    public static boolean isPalindrome(GSHSingleNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        GSHSingleNode cur = head;

        // 12345
        GSHSingleNode half = head;

        while (half.next != null && half.next.next != null) {
            cur = cur.next;
            half = half.next.next;
        }

        Stack<GSHSingleNode> stack = new Stack<>();

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        half = head;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur.value == half.value) {
                half = half.next;
            } else {
                return false;
            }
        }
        return true;
    }

    // 空间复杂度为1
    public static boolean isPalindrom2(GSHSingleNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        int size = GSHLinkUtils.sizeS(head);
        if (size == 2 && (head.value != head.next.value)) {
            return false;

        }

        GSHSingleNode start = head;

        head = Code03_reverseList.reverseSPart(head, (size + 1) / 2 + 1, size);

        GSHLinkUtils.printList(head);

        int index = 1;
        while (index < ((size + 1) / 2 + 1)) {
            start = start.next;
            index++;
        }

        while (start != null) {
            if (start.value != head.value) {
                return false;
            }
            start = start.next;
            head = head.next;
        }

        return true;


    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1};
        GSHSingleNode head = GSHLinkUtils.getList(arr);
        System.out.println(isPalindrome(head));
        System.out.println(isPalindrom2(head));

    }


}
