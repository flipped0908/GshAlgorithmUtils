package gsh.demo.practice03_Tree;

/**
 * 判断 t1 是否包含 t2 的拓扑结构
 */
public class Code11_TreeContainOtherStruct {

    public static boolean contains(TreeNode t1, TreeNode t2) {

        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        if (t1.value != t2.value) {
            return false;
        }
        boolean r1 = contains(t1.left, t2.left);
        boolean r2 = contains(t1.right, t2.right);
        return r1 && r2;

    }


}
