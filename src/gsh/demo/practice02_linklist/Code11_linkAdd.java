package gsh.demo.practice02_linklist;

/**
 * 9-7-3
 * 6-7
 * 返回 1-0-0-0
 */
public class Code11_linkAdd {

    public static GSHSingleNode addlist(GSHSingleNode head1, GSHSingleNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        head1 = reverse(head1);
        head2 = reverse(head2);

        GSHSingleNode res = null;
        GSHSingleNode rescur = null;


        int more = 0;
        while (head1 != null && head2 != null) {

            int k = head1.value + head2.value + more;

            int t = k > 9 ? k % 10 : k;
            more = k > 9 ? 1 : 0;

            if (res == null) {
                res = new GSHSingleNode(t);
                rescur = res;
            } else {
                rescur.next = new GSHSingleNode(t);
                rescur = rescur.next;
            }
            head1 = head1.next;
            head2 = head2.next;
            if (head1 == null && head2 == null) {
                if(more==1){
                    rescur.next=new GSHSingleNode(1);
                }
                return reverse(res);
            }
        }
        GSHLinkUtils.printList(res);

        GSHSingleNode tmp = head1 == null ? head2 : head1;

        while (tmp != null) {
            int k = tmp.value + more;
            int t = k > 9 ? k % 10 : k;
            more = k > 9 ? 1 : 0;
            rescur.next = new GSHSingleNode(t);
            rescur = rescur.next;
            GSHLinkUtils.printList(res);
            tmp = tmp.next;
            if (tmp == null && more == 1) {
                rescur.next = new GSHSingleNode(1);
            }
        }
        return reverse(res);


    }


    public static GSHSingleNode reverse(GSHSingleNode head) {

        GSHSingleNode pre = null;
        while (head != null) {
            GSHSingleNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;

    }

    public static void main(String[] args) {
        int[] a = {9, 3, 7};
        int[] b = {1, 6, 3};

        GSHLinkUtils.printList(addlist(GSHLinkUtils.getList(a), GSHLinkUtils.getList(b)));


    }


}
