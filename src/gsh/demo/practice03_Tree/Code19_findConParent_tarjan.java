package gsh.demo.practice03_Tree;

import java.util.*;

public class Code19_findConParent_tarjan {

    public class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public class UnionFindSet<V> {
        public HashMap<V, Element<V>> elementMap;
        public HashMap<Element<V>, Element<V>> fatherMap;
        public HashMap<Element<V>, Integer> rankMap;

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<V>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                rankMap.put(element, 1);
            }
        }

        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            while (element != fatherMap.get(element)) {
                path.push(element);
                element = fatherMap.get(element);
            }
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), element);
            }
            return element;
        }

        public V fingHead(V value) {
            return elementMap.containsKey(value) ? fingHead(elementMap.get(value).value) : null;
        }

        public boolean isSameSet(V v1, V v2) {
            if (elementMap.containsKey(v1) && elementMap.containsKey(v2)) {
                return fingHead(v1) == fingHead(v2);
            }
            return false;
        }

        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aF = findHead(elementMap.get(a));
                Element<V> bF = findHead(elementMap.get(b));
                if (aF != bF) {
                    Element<V> big = rankMap.get(aF) > rankMap.get(bF) ? aF : bF;
                    Element<V> smal = big == aF ? bF : aF;
                    fatherMap.put(smal, big);
                    rankMap.put(big, rankMap.get(big) + rankMap.get(smal));
                    rankMap.remove(smal);
                }
            }
        }
    }


    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    public class Query {
        public Node o1;
        public Node o2;

        public Query(Node o1, Node o2) {
            this.o1 = o1;
            this.o2 = o2;
        }
    }


    public Node[] tarjanQuery(Node head, Query[] queries) {
        HashMap<Node, LinkedList<Node>> querymap = new HashMap<>();
        HashMap<Node, LinkedList<Integer>> indexMap = new HashMap<>();
        HashMap<Node, Node> ancetorMap = new HashMap<>();
        UnionFindSet<Node> sets = new UnionFindSet<>(getallNodes(head));
        Node[] ans = new Node[queries.length];
        setQueriesAndSetEasyAnswers(queries, ans, querymap, indexMap);
        setAnswers(head, ans, querymap, indexMap, ancetorMap, sets);
        return ans;
    }


    public void setAnswers(Node head, Node[] ans,
                           HashMap<Node, LinkedList<Node>> queryMap,
                           HashMap<Node, LinkedList<Integer>> indexMap,
                           HashMap<Node, Node> ancetorMap, UnionFindSet<Node> sets) {
        if (head == null) {
            return;
        }

        setAnswers(head.left, ans, queryMap, indexMap, ancetorMap, sets);
        sets.union(head, head.left);
        ancetorMap.put(sets.fingHead(head), head);
        setAnswers(head.right, ans, queryMap, indexMap, ancetorMap, sets);
        sets.union(head.right, head);
        ancetorMap.put(sets.fingHead(head), head);
        LinkedList<Node> nlist = queryMap.get(head);
        LinkedList<Integer> ilist = indexMap.get(head);
        Node node = null;
        Node nodeFather = null;
        int index = 0;
        while (nlist != null && !nlist.isEmpty()) {
            node = nlist.poll();
            index = ilist.poll();
            nodeFather = sets.fingHead(node);
            if (ancetorMap.containsKey(nodeFather)) {
                ans[index] = ancetorMap.get(nodeFather);
            }

        }


    }


    public void setQueriesAndSetEasyAnswers(Query[] ques, Node[] ans,
                                            HashMap<Node, LinkedList<Node>> queryMap,
                                            HashMap<Node, LinkedList<Integer>> indexMap) {
        Node o1 = null;
        Node o2 = null;
        for (int i = 0; i < ans.length; i++) {
            o1 = ques[i].o1;
            o2 = ques[i].o2;
            if (o1 == null || o2 == null || o1 == o2) {
                ans[i] = o1 == null ? o2 : o1;
            } else {
                if (!queryMap.containsKey(o1)) {
                    queryMap.put(o1, new LinkedList<Node>());
                    indexMap.put(o1, new LinkedList<Integer>());
                }
                if (!queryMap.containsKey(o2)) {
                    queryMap.put(o2, new LinkedList<Node>());
                    indexMap.put(o2, new LinkedList<Integer>());
                }
                queryMap.get(o1).addLast(o2);
                indexMap.get(o1).add(i);
                queryMap.get(o2).addLast(o1);
                indexMap.get(o1).add(i);
            }
        }
    }


    public List<Node> getallNodes(Node head) {
        List<Node> list = new ArrayList<>();
        process(head, list);
        return list;

    }


    private void process(Node head, List<Node> res) {
        if (head == null) {
            return;
        }
        res.add(head);
        process(head.left, res);
        process(head.right, res);
    }


}
