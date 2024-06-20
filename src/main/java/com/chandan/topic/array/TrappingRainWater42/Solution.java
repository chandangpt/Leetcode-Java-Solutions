package com.chandan.topic.array.TrappingRainWater42;

class Solution {
    //Approach 1 : For particular index find the left and right max height tower and then calculate water store on index
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[height.length - 1] = height[height.length - 1];
        for(int i = 1; i < height.length; i++)
            left[i] = Math.max(height[i], left[i - 1]);
        for(int i = height.length - 2; i >= 0; i--)
            right[i] = Math.max(height[i], right[i + 1]);
        int ans = 0;
        for(int i = 0; i < height.length; i++) {
            ans += Math.min(right[i], left[i]) - height[i];
        }
        return ans;
    }

    //Approach 2: For particular index calculating water store by having knowledge of minimum of left and right tower
    public int trap2(int[] height) {
        int lMax = 0, rMax = 0, ans = 0, n = height.length;
        for(int i = 0, j = n - 1; i < j;) {
            lMax = Math.max(lMax, height[i]);
            rMax = Math.max(rMax, height[j]);
            ans += lMax > rMax ? rMax - height[j--] : lMax - height[i++];
        }
        return ans;
    }
}
