package gsh.zuocom.unionfindset;

import java.util.HashMap;
import java.util.List;

public class UFSData {
    public HashMap<UFSNode, UFSNode> fathermap;
    public HashMap<UFSNode, Integer> sizemap;

    public UFSData() {
        fathermap = new HashMap<>();
        sizemap = new HashMap<>();
    }


    // 初始化 集合中 所有的节点

    public void createSet(List<UFSNode> L) {
        fathermap.clear();
        sizemap.clear();
        for (UFSNode ufsNode : L) {
            fathermap.put(ufsNode, ufsNode);
            sizemap.put(ufsNode, 1);
        }
    }

    // 找 某个节点的头节点

    public UFSNode findHead(UFSNode node) {
        while (fathermap.get(node) != node) {
            node = fathermap.get(node);
        }
        return node;
    }

    // 判断两个节点是否是一个集合

    public boolean isSameSet(UFSNode n1, UFSNode n2) {
        return findHead(n1) == findHead(n2);
    }


    // 合并两个集合

    public void nuion(UFSNode n1, UFSNode n2) {
        if (n1 == null || n2 == null) {
            return;
        }

        UFSNode head1 = findHead(n1);
        UFSNode head2 = findHead(n2);

        if (head1 != head2) {
            int size1 = sizemap.get(head1);
            int size2 = sizemap.get(head2);

            if (size1 <= size2) {
                fathermap.put(head1, head2);
                sizemap.put(head2, size1 + size2);
            } else {
                fathermap.put(head2, head1);
                sizemap.put(head1, size1 + size1);
            }

        }


    }


}
