package practice2019.part9;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集
 * <p>
 * 总结： 还是说怎么设计一个 数据结构 来支撑整个算法
 * <p>
 * 先设计好了数据结构 才能 做好算法
 */
public class Code14_UnionSearchSet {

    /**
     * 给定一个没有重复的整数型数组 ，初始认为 arr 中没有个数都是一个单独的集合，设计一种unionFind的结构
     * 实现
     * 1 查询 a 和 b 这两个数是否属于一个集合
     * 2 void union（int a, int b）  把a所在的集合与b所在的集合合并在一起，原本两个集合各自的元素 以后都算做同一个集合
     */

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

        public Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            while (element != fatherMap.get(element)) {
                path.push(element);
                element = fatherMap.get(element);
            }
            return element;
        }


        public boolean isSameSet(V a, V b) {
            if (findHead(elementMap.get(a)) == findHead(elementMap.get(b))) {
                return true;
            }
            return false;
        }

        public void union(V a, V b) {

            Element<V> af = findHead(elementMap.get(a));
            Element<V> bf = findHead(elementMap.get(b));

            if (af != bf) {
                Element<V> big = rankMap.get(af) >= rankMap.get(bf) ? af : bf;
                Element<V> small = big == af ? bf : af;
                fatherMap.put(small, big);
                rankMap.put(big, rankMap.get(af) + rankMap.get(bf));
                rankMap.remove(small);

            }

        }
    }

}
