package gsh.demo.practice01_stackandqueue;


import java.util.Stack;

/**
 * 实现一个特殊的栈 ，除了栈的基本功能之外还有实现返回栈中最小的元素
 */
public class Code01_GetMin {


    // 用 两个栈实现

    public static class MyStack {

        private Stack<Integer> stackData;

        private Stack<Integer> stackMin;

        public MyStack() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int item) {
            if (stackData.isEmpty()) {
                stackMin.push(item);
            } else {
                if (item < getMin()) {
                    stackMin.push(item);
                } else {
                    stackMin.push(getMin());
                }
            }
            stackData.push(item);
        }


        public int pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("");
            }
            stackMin.pop();
            return stackData.pop();

        }

        public int getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException(" stack is empty");
            }
            return stackMin.peek();
        }
    }

}
