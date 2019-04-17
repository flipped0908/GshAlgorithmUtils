package gsh.demo.practice01_stackandqueue;


import java.util.Stack;

/**  ^
 *
 * 用一个栈实现另一个栈的排序
 *
 * 从顶到底按从大到小的顺序，只允许申请一个栈，除此之外可以申请新的变量，但是不能申请额外的数据结构。
 *
 */

public class Code05_SortStack {


    public static void sort(Stack<Integer> stack){


    }

    public static void orgToSortStack(Stack<Integer> orgstack ,Stack<Integer> sortstack){

        if(orgstack.isEmpty()){
            return;
        }

        int i = orgstack.pop();

        if(sortstack.isEmpty()){
            sortstack.push(i);
        }

        while (i<sortstack.peek() && !orgstack.isEmpty()){
            sortstack.push(i);
            i = orgstack.pop();
        }
    }

    public static void sortToOrgStack(Stack<Integer> orgstack ,Stack<Integer> sortstack,int key) {
        if(sortstack.isEmpty()){
            return;
        }
        int i = sortstack.pop();


    }




}
