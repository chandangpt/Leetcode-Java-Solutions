package com.chandan.neetcode150.stack.EvaluateReversePolishNotation150;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+"))
                stack.add(stack.pop() + stack.pop());
            else if(tokens[i].equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b - a);
            }
            else if(tokens[i].equals("*"))
                stack.add(stack.pop() * stack.pop());
            else if(tokens[i].equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b / a);
            } else {
                int num = Integer.parseInt(tokens[i]);
                stack.add(num);
            }
        }
        return stack.pop();
    }
}
