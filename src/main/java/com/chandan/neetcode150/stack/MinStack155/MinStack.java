package com.chandan.neetcode150.stack.MinStack155;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }

    public void push(int val) {
        stack.add(val);
        int minValue = minStack.isEmpty() ? val : Math.min(minStack.peek(), val);
        minStack.add(minValue);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
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
