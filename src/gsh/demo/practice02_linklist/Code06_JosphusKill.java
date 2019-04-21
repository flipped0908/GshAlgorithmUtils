package gsh.demo.practice02_linklist;

/**
 * 环形单链表约瑟夫问题
 */
public class Code06_JosphusKill {


    public static GSHSingleNode josphusKill(GSHSingleNode head) {

        int index = 0;
        GSHSingleNode cur = head;
        GSHSingleNode pre = null;
        while (cur.next != cur) {
//            if (cur.next.next == cur) {
//                break;
//            }
            if (index == 1) {
                pre = cur;
            }
            if (index == 2) {
                GSHSingleNode next = cur.next;
                pre.next = next;
            }
            index = index == 2 ? -1 : index;
            cur = cur.next;
            index++;
        }
        return cur;

    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        GSHLinkUtils.printCircleList(josphusKill(GSHLinkUtils.getCircleList(arr)));
        System.out.println(getnum(8, 3));
    }


    /**
     * O(N) 的算法
     */


    public static int getnum(int i, int m) {

        if (i == 1) {
            return 1;
        }
        return (getnum(i - 1, m) + m - 1) % i + 1;


    }


}
