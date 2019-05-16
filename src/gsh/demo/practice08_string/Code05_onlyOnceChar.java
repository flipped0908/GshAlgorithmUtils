package gsh.demo.practice08_string;

/**
 * 判断字符串数组中是否所有的字符都只出现过一次
 */
public class Code05_onlyOnceChar {

    public boolean isUniquel(char[] chars) {
        if (chars == null) {
            return false;
        }
        boolean[] map = new boolean[26];
        for (int i = 0; i < chars.length; i++) {
            if (map[i]) {
                return false;
            }
            map[i] = true;
        }
        return true;
    }

    /**
     * 堆排序之后 遍历
     */

}
