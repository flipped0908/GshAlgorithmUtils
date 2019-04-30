package gsh.zuocom.tiretree;

import gsh.demo.practice03_Tree.TreeNode;

public class TireNode {

    public int path;
    public int end;

    public TireNode[] nexts;

    public TireNode() {
        path = 0;
        end = 0;
        nexts = new TireNode[26];
    }

}
