package practice2019.part9;

import java.util.HashMap;




public class Code11_LRUCache {

    public class Node<V> {
        public V value;
        public Node<V> last;
        public Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }

    private class NodeDoubleLinkedList<V> {

        private Node<V> head;
        private Node<V> tail;

        public NodeDoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void addNode(Node<V> newNode) {
            if (newNode == null) {
                return;
            }
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                this.tail.next = newNode;
                newNode.last = this.tail;
                this.tail = newNode;
            }
        }

        public void moveNodeToTail(Node<V> node) {
            if (this.tail == node) {
                return;
            }
            if (this.head == node) {
                this.head = node.next;
                this.head.last = null;
            } else {
                node.last.next = node.next;
                node.next.last = node.last;
            }
            node.last = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;
        }

        public Node<V> removeHead() {
            if (this.head == null) {
                return null;
            }
            Node<V> res = this.head;
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = res.next;
                res.next = null;
                this.head.last = null;
            }
            return res;
        }
    }


    public class MyCache<K, V> {

        private HashMap<K, Node<V>> keyNodeMap;
        private HashMap<Node<V>, K> nodeKeyMap;
        private NodeDoubleLinkedList<V> nodeList;
        private int capacity;

        public MyCache(int capacity) {
            if (capacity < 1) {
            }
            this.keyNodeMap = new HashMap<K, Node<V>>();
            this.nodeKeyMap = new HashMap<>();
            this.nodeList = new NodeDoubleLinkedList<>();
            this.capacity = capacity;
        }

        public V get(K key) {
            if (this.keyNodeMap.containsKey(key)) {
                Node<V> res = this.keyNodeMap.get(key);
                this.nodeList.moveNodeToTail(res);
                return res.value;
            }
            return null;
        }

        public void set(K key, V value) {

            if (keyNodeMap.containsKey(key)) {

                nodeList.moveNodeToTail(keyNodeMap.get(key));
            } else {
                Node<V> node = new Node<>(value);
                nodeList.addNode(node);
                if (keyNodeMap.size() == capacity + 1) {
                    removeMostUnusedCache();
                }

            }

        }

        private void removeMostUnusedCache() {

        }


    }

}
