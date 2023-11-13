package com.chandan.designproblems.ImplementQueueusingStacks232;

import java.util.Stack;

class MyQueue {

    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    public MyQueue() {
        pushStack = new Stack();
        popStack = new Stack();
    }

    public void push(int x) {
        pushStack.add(x);
    }

    public int pop() {
        initPopStack();
        return popStack.pop();
    }

    private void initPopStack() {
        if(popStack.isEmpty()) {
            while(!pushStack.isEmpty())
                popStack.add(pushStack.pop());
        }
    }

    public int peek() {
        if(!popStack.isEmpty())
            return popStack.peek();
        initPopStack();
        return popStack.peek();
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
