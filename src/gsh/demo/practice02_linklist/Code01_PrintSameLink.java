package gsh.demo.practice02_linklist;

/**
 * 给定两个有序链表的头指针 head1 和 head2 打印公共的部分
 */

public class Code01_PrintSameLink {

    public static void printCommonPart(GSHSingleNode head1, GSHSingleNode head2) {

        if (head1 == null || head2 == null) {
            return;
        }

        while (head1 != null && head2 != null) {
            if (head1.value == head2.value) {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.value < head2.value) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }
    }

}
