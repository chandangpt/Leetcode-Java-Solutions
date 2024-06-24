package com.chandan.topic.array.MaximumSubarray53;

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(currSum + nums[i] > 0) {
                currSum += nums[i];
                maxSum = Math.max(maxSum, currSum);
            }
            else {
                currSum = 0;
                maxSum = Math.max(maxSum, nums[i]);
            }
        }
        return maxSum;
    }
}
