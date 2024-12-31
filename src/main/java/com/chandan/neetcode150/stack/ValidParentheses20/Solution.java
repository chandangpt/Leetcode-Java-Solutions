package com.chandan.neetcode150.stack.ValidParentheses20;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[')
                stack.add(ch);
            else {
                if(stack.isEmpty())
                    return false;
                Character topElem = stack.pop();
                if(ch == ')' && topElem != '(' ||
                        ch == ']' && topElem != '[' ||
                        ch == '}' && topElem != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}