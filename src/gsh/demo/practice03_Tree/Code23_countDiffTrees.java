package gsh.demo.practice03_Tree;

/**
 * 统计和生成所有不同的二叉树
 */
public class Code23_countDiffTrees {

    public static int nums(int n) {
        if (n < 2) {
            return 1;
        }
        int[] num = new int[n + 1];
        num[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                num[i] = num[j - 1] * num[j + 1];
            }
        }
        return num[n];

    }


}
