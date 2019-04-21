package gsh.demo.practice02_linklist;

public class GSHLinkUtils {


    public static boolean hasNext(GSHSingleNode node){
        if(node.next==null){
            return false;
        }
        return true;
    }


    public static GSHSingleNode getList(int[] arr){
        if(arr == null || arr.length == 0){
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

    public static void printList(GSHSingleNode head){
        if(head == null){
            return;
        }
        GSHSingleNode cur = head;
        while (cur!=null){
            System.out.print(" "+cur.value+" -> ");
            cur = cur.next;
        }
        System.out.print(" null");
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        printList(getList(arr));
    }


}
