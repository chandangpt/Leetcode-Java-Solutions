package com.chandan.neetcode150.stack.GenerateParentheses22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    private List<String> result;
    private Stack<Character> stack;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        stack = new Stack();
        generateParenthesisUtil(0, 0, n);
        return result;
    }

    public void generateParenthesisUtil(int openCount, int closeCount, int n) {
        if(openCount == closeCount && closeCount == n) {
            StringBuilder sb = new StringBuilder();
            for(Character ch : stack)
                sb.append(ch);
            result.add(sb.toString());
        }
        if(openCount < n) {
            stack.add('(');
            generateParenthesisUtil(openCount + 1, closeCount, n);
            stack.pop();
        }
        if(openCount > closeCount) {
            stack.add(')');
            generateParenthesisUtil(openCount, closeCount + 1, n);
            stack.pop();
        }
    }
}
