package com.chandan.topic.design.BasicCalculator224;

import java.util.Stack;

public class Calculator {
    public int calculate(String s) {
        int ans = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while((i + 1 < s.length()) && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                num *= sign;
                ans += num;
                sign = 1;
            } else if(s.charAt(i) == '-') {
                sign = -1;
            } else if(s.charAt(i) == '+') {
                sign = 1;
            } else if(s.charAt(i) == '(') {
                stack.push(ans);
                stack.push(sign);
                sign = 1;
                ans = 0;
            } else if(s.charAt(i) == ')') {
                ans = ans * stack.pop() + stack.pop();
            }
        }
        return ans;
    }
}