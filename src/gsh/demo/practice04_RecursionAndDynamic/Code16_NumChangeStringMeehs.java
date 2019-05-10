package gsh.demo.practice04_RecursionAndDynamic;

/**
 * 数字字符串 转化为字母组合的种数
 */
public class Code16_NumChangeStringMeehs {

    /**
     * 暴力递归
     *
     * 两个边界条件
     *
     * 两个分支
     *
     */

    public int process(char[] chars, int i) {
        if (i == chars.length) {
            return 1;
        }
        if (chars[i] == '0') {
            return 0;
        }

        int res = process(chars, i + 1);

        if (i + 1 < chars.length && ((chars[i] - '0') * 10 + (chars[i + 1] - '0')) < 27) {
            res += process(chars, i + 2);
        }
        return res;
    }


    /**
     * p(i) 依赖 p（i） 和 p（i+1） 两个值。
     */
















}
