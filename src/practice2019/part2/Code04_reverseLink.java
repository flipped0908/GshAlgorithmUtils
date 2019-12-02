package practice2019.part2;

import java.security.PublicKey;

/**
 *  反转 单向链表
 */
public class Code04_reverseLink {

    public class Node {
        public int value;
        public Node next;
        public Node(int data){
            this.value =  data;
        }

        public Node reverseList(Node head){
            Node cur = head;
            Node pre = null;
            Node next = null;
            while (cur != null){
                next =  cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return cur;
        }
    }

}
