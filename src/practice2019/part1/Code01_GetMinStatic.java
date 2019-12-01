package practice2019.part1;


import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 *
 * 总结 ：
 *  用两个栈来维护有这个功能的栈。多浪费了一些空间。
 */
public class Code01_GetMinStatic {

    private Stack<Integer> stackDate;

    private Stack<Integer> stackMin;

    public Code01_GetMinStatic() {
        this.stackDate = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNumber) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNumber);
        } else if (newNumber <= getMin()) {
            this.stackMin.push(newNumber);
        }
        stackDate.push(newNumber);
    }

    public int pop() {
        if(this.stackDate.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        int value  =  this.stackDate.pop();
        if(value == getMin()){
            this.stackMin.pop();
        }
        return value;
    }


    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return this.stackMin.peek();
    }


}
