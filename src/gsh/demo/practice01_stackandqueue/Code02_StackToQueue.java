package gsh.demo.practice01_stackandqueue;


import java.util.Stack;

/**
 * 两个栈实现队列，支持基本操作，add ，poll，peek
 */
public class Code02_StackToQueue {

    // 用两个栈 实现

    public static class MyQueue {

        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public MyQueue() {
            stackPop = new Stack<>();
            stackPush = new Stack<>();
        }

        public void add(int item) {
            stackPush.push(item);
        }

        public int peek() {
            if (!stackPop.isEmpty()) {
                return stackPop.peek();
            } else {
                if (stackPush.isEmpty()) {
                    throw new RuntimeException("queue is  empty");
                }
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
                return stackPop.peek();
            }
        }


        public int poll() {
            if (!stackPop.isEmpty()) {
                return stackPop.pop();
            } else {
                if (stackPush.isEmpty()) {
                    throw new RuntimeException("queue is  empty");
                }
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
                return stackPop.pop();
            }
        }


    }


}
