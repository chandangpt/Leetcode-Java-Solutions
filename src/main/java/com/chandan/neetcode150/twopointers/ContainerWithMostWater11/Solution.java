package com.chandan.neetcode150.twopointers.ContainerWithMostWater11;

public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for(int i = 0, j = height.length - 1; i < j;) {
            int currArea = (j - i) * Math.min(height[i], height[j]);
            if(maxArea < currArea)
                maxArea = currArea;
            if(height[i] < height[j])
                i++;
            else
                j--;
        }
        return maxArea;
    }
}
