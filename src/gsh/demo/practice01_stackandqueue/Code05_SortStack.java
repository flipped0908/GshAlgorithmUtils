package gsh.demo.practice01_stackandqueue;


import java.util.Stack;

/**
 * ^
 * <p>
 * 用一个栈实现另一个栈的排序
 * <p>
 * 从顶到底按从大到小的顺序，只允许申请一个栈，除此之外可以申请新的变量，但是不能申请额外的数据结构。
 */

public class Code05_SortStack {


    public static Stack<Integer> sort(Stack<Integer> stack) {

        Stack<Integer> sortS = new Stack<>();

        while (!stack.isEmpty()) {
            orgToSortStack(stack, sortS);
            if(stack.isEmpty()){
                return sortS;
            }
            int i = stack.pop();
            sortToOrgStack(stack, sortS, i);
        }

        return sortS;
    }

    public static void orgToSortStack(Stack<Integer> orgstack, Stack<Integer> sortstack) {

        if (orgstack.isEmpty()) {
            return;
        }
        if (sortstack.isEmpty()) {
            sortstack.push(orgstack.pop());
        }
        while (!orgstack.isEmpty() && !sortstack.isEmpty() && orgstack.peek() < sortstack.peek()) {
            sortstack.push(orgstack.pop());
        }

    }

    public static void sortToOrgStack(Stack<Integer> orgstack, Stack<Integer> sortstack, int key) {
        if (sortstack.isEmpty()) {
            return;
        }
        while (!sortstack.isEmpty() && sortstack.peek() < key) {
            orgstack.push(sortstack.pop());
        }
        sortstack.push(key);
    }

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(9);
        s.push(3);
        s.push(6);
        s.push(8);
        s.push(5);


        // 1 9 3 6 8 5

        s = sort(s);


        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

    }



    // 注意点
    // 调代码的过程中 边界条件容易出错， 逻辑一定要清楚， 复杂的逻辑必然容易错误， 一旦逻辑变得复杂就要考虑是否出错了

    // 作者写法 简单优雅

    public static  void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()){
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() <cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }

    }






}
