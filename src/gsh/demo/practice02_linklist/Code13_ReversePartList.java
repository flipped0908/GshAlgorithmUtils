package gsh.demo.practice02_linklist;

/**
 * 将单链表的每k个节点逆序
 */
public class Code13_ReversePartList {


    public static GSHSingleNode reverst(GSHSingleNode head, int k) {

        int size = GSHLinkUtils.sizeS(head);

        for (int i = 0; i < size / k; i++) {
            /**
             *  1   3
             *  4   6
             *  7   9
             */
            head = GSHLinkUtils.reverse(head, i * k + 1, (i + 1) * k);
        }

        return head;

    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        GSHSingleNode head = GSHLinkUtils.getList(arr);

        GSHLinkUtils.printList(head);

        GSHLinkUtils.printList(reverst(head, 5));

    }


}
