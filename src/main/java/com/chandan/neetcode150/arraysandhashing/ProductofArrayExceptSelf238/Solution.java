package com.chandan.neetcode150.arraysandhashing.ProductofArrayExceptSelf238;

import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        int leftProd = nums[0];
        for(int i = 1; i < nums.length; i++) {
            ans[i] = leftProd;
            leftProd *= nums[i];
        }
        int rightProd = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--) {
            ans[i] = ans[i] * rightProd;
            rightProd *= nums[i];
        }
        return ans;
    }
}