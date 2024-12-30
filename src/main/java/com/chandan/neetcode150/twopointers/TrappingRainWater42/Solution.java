package com.chandan.neetcode150.twopointers.TrappingRainWater42;

public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for(int i = 0; i < n - 1; i++) {
            leftMax[i + 1] = Math.max(leftMax[i], height[i]);
        }
        for(int i = n - 1; i > 0; i--) {
            rightMax[i - 1] = Math.max(rightMax[i], height[i]);
        }
        int totalWater = 0;
        for(int i = 0; i < n ; i++) {
            int canFillWater = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(canFillWater > 0)
                totalWater += canFillWater;
        }
        return totalWater;
    }

    public int trap1(int[] height) { // Optimised space using two pointers
        int n = height.length, i = 0, j = n - 1, leftMax = height[0], rightMax = height[n - 1];
        int trappedWater = 0;
        while(i < j) {
            if(leftMax < rightMax) {
                i++;
                leftMax = Math.max(leftMax, height[i]);
                trappedWater += leftMax - height[i];
            } else {
                j--;
                rightMax = Math.max(rightMax, height[j]);
                trappedWater += rightMax - height[j];
            }
        }
        return trappedWater;
    }
}
