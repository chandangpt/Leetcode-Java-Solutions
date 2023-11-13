package com.chandan.designproblems.MinStack155;

import java.util.Stack;

class MinStack1 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MinStack1() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        if(stack2.isEmpty() || stack2.peek() >= val) {
            stack2.push(val);
        }
        stack1.add(val);
    }

    public void pop() {
        int val = stack1.pop();
        if(stack2.peek() == val) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
