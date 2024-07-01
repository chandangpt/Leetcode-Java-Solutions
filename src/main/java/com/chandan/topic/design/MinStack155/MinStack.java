package com.chandan.topic.design.MinStack155;

import java.util.Stack;

class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack; // 1 stack

    public MinStack() {
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
