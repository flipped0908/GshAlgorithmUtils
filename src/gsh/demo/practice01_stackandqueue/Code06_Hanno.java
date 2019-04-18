package gsh.demo.practice01_stackandqueue;


import java.sql.SQLOutput;
import java.util.Stack;

/**
 * three *
 * 用栈来求解汉诺塔的问题   条件: 不能跨过中间
 * <p>
 * 方法一 递归的方法
 * <p>
 * 方法二 非递归的方法 用栈来模拟汉诺塔的3个塔
 */

public class Code06_Hanno {


    /**
     * 普通的汉诺塔方法
     */

    public static void process(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("Move 1 from: " + from + " to: " + to);
        } else {
            process(n - 1, from, help, to);
            System.out.println("Move " + n + " from: " + from + " to: " + to);
            process(n - 1, help, to, from);
        }
    }


    /***
     *   hanoi
     *
     *   递归方法  不能跨过中间的杆
     *
     *
     *   把 每一个子问题的步骤分析清楚了就可以根据 子问题的步骤开始
     *
     *
     *   basecase  边界条件  可以直接计算出结果的  最可能的是 第一个 和第n个
     *
     *
     *   数学归纳法
     *
     */


    public int hanoiProcess(int num, String left, String mid, String right, String from, String to) {

        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("M 1 from " + from + "  to  " + to);
                return 1;
            } else {
                System.out.println("M 1 from " + from + "  to  " + mid);
                System.out.println("M 1 from " + mid + "  to  " + to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)) {

            String another = from.equals(mid) ? to.equals(left) ? right : left : from.equals(left) ? right : left;
            int a = hanoiProcess(num - 1, left, mid, right, from, another);
//            int b = hanoiProcess(1, left, mid, right, from, to);
            int b = 1;
            System.out.println("M " + num + " from " + from + "  to  " + mid);
            int c = hanoiProcess(num - 1, left, mid, right, another, from);

            return a + b + c;

        } else {
            int a = hanoiProcess(num - 1, left, mid, right, from, to);
            int b = 1;
            System.out.println("M " + num + " from " + from + "  to  " + mid);
            int c = hanoiProcess(num - 1, left, mid, right, to, from);
            int d = 1;
            System.out.println("M " + num + " from " + mid + "  to  " + to);
            int e = hanoiProcess(num - 1, left, mid, right, from, to);
            return a + b + c + d + e;
        }
    }


    /**
     * hanoi
     * <p>
     * 非递归
     *
     * 只会有四种行为
     *
     * 根据上一步的动作  和 小不压大的原则  下一步只会有一个动作发生
     *
     * 有个结束条件
     *
     * 在结束条件之前 一个while  里边只会有一个分支发生计算
     *
     * 任何 递归行为 都可以改为 非递归 ，因为递归就是用的一个超大的栈  栈中的每一个元素的数据包括  参数 返回值 局部变量 函数
     *
     * 单独的递归函数 就是栈中的元素类型一样， 如果递归元素有分支，就是一个元素变为了栈
     *
     *
     */


    public enum Action {
        NO, LTOM, MTOL, RTOM, MTOR
    }

    //

    public static int hanoiProblem(int num, String left, String mid, String rigjt) {

        Stack<Integer> lS = new Stack<>();
        Stack<Integer> mS = new Stack<>();
        Stack<Integer> rS = new Stack<>();

        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);

        for (int i = num; i > 0; i--) {
            lS.push(i);
        }


        Action[] record = {Action.NO};

        int step = 0;

        while (rS.size() != num + 1) {
            step += fStackToStack(record, Action.MTOL, Action.LTOM, lS, mS, left, mid);
            step += fStackToStack(record, Action.LTOM, Action.MTOL, mS, lS, mid, left);
            step += fStackToStack(record, Action.MTOR, Action.RTOM, rS, mS, rigjt, mid);
            step += fStackToStack(record, Action.RTOM, Action.MTOR, mS, rS, mid, rigjt);
        }

        return step;
    }


    public static int fStackToStack(Action[] record, Action preAction, Action nowAction,
                                    Stack<Integer> fStack, Stack<Integer> tStack, String from, String to) {
        if (record[0] != preAction && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            System.out.println("M " + tStack.peek() + " from " + from + "  to  " + to);
            record[0] = nowAction;
            return 1;
        }
        return 0;

    }



}
