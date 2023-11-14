package com.chandan.designproblems.MaxStack716;

import java.util.Stack;

public class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> max;

    public MaxStack() {
        stack = new Stack<>();
        max = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
        int maxValue = max.isEmpty() ? x : Math.max(x, max.peek());
        max.push(maxValue);
    }

    public int pop() {
        max.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return max.peek();
    }

    public int popMax() {
        int maxValue = max.pop();
        Stack<Integer> temp = new Stack<>();
        while(stack.peek() != maxValue) {
            temp.push(stack.pop());
        }
        stack.pop();
        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return maxValue;
    }
}
