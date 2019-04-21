package gsh.demo.practice02_linklist;

/**
 * 删除单链表 和 双链表 倒数第 K 的节点
 */
public class Code02_DeleteNodeAtIndex {


    public static void deleteNode(GSHDoubleNode head, int k) {
        if (head == null || k < 0 || k > size(head)) {
            return;
        }
        if (size(head) == 1 && k == 1) {
            head = null;
            return;
        }

        int index = endKIndex(head, k);
        while (head.hasNext() && index > -1) {
            head = head.next;
            index--;
        }

        // 第一个node
        if (index == 0) {
            GSHDoubleNode next = head.next;
            head.next = null;
            next.pre = null;
        }
        // 最后一个node
        else if (index == size(head)) {
            GSHDoubleNode pre = head.pre;
            head.pre = null;
            pre.next = null;
        } else {
            GSHDoubleNode pre = head.pre;
            GSHDoubleNode next = head.next;
            head.pre = null;
            head.next = null;
            pre.next = next;
            next.pre = pre;
        }

        // 中间的node

    }

    public static int size(GSHDoubleNode node) {
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

    public static int endKIndex(GSHDoubleNode node, int k) {
        int size = size(node);
        return size - k;
    }


}


/**
 *
 * 总结  考虑输入参数的校验  和边界的处理  这是程序员的基本素质
 *
 * 提炼一个方法
 *
 * 比如删除 链表中第k个节点
 *
 * 这样不管你是什么的题
 *
 * 就像适配器一样 找到要删除的节点是第几个   比如 倒数第k个 中间节点  a/b处的节点
 *
 */
















