package com.chandan.neetcode150.stack.DailyTemperatures739;
import java.util.Stack;
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.add(i);
        }
        return answer;
    }
}
