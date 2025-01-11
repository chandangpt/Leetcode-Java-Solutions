package com.chandan.neetcode150.stack.LargestRectangleInHistogram84;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair<Integer, Integer>> stack = new Stack();
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            int start = i;
            while(!stack.isEmpty() && stack.peek().getValue() > heights[i]) {
                Pair<Integer, Integer> top = stack.pop();
                int index = top.getKey();
                int height = top.getValue();
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            stack.add(new Pair(start, heights[i]));
        }
        while(!stack.isEmpty()) {
            Pair<Integer, Integer> top = stack.pop();
            int index = top.getKey();
            int height = top.getValue();
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }
        return maxArea;
    }
}