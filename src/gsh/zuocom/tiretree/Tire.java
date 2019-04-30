package gsh.zuocom.tiretree;

public class Tire {

    public TireNode root;

    public Tire() {
        root = new TireNode();
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TireNode node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            index = c - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TireNode();
            }
            node = node.nexts[index];
            node.path++;
        }
        node.end++;
    }

    public int find(String word) {
        if (word == null) {
            return 0;
        }
        char[] chars = word.toCharArray();
        TireNode node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }


}
