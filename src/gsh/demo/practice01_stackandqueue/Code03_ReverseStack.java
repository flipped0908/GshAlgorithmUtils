package gsh.demo.practice01_stackandqueue;


import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

/**
 * 仅用递归函数和栈逆序一个栈
 * <p>
 * 12345  -  54321
 * <p>
 * 只能用递归函数来实现， 不能用其他数据结构
 */
public class Code03_ReverseStack {


//    public static Stack<Integer> process(Stack<Integer> stack ,int flg){
//
//        if(stack.isEmpty()){
//            throw new RuntimeException("stack is  empty");
//        }
//        return null;
//
//    }


    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        reverse(stack);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    /**
     *
     * 递归函数本身就是一个数据结构 一个大的栈
     * 递归函数本身可以理解为一个结构体，里边是有变量和 函数的
     *
     * 想到python中一切皆对象，函数也是对象
     *
     */


}
