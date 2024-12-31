package com.chandan.neetcode150.stack.MinStack155;

import java.util.Stack;

public class MinStackSingleStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;

    public MinStackSingleStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(val <= min) {
            stack.add(min);
            min = val;
        }
        stack.add(val);
    }

    public void pop() {
        if(min == stack.pop()) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
