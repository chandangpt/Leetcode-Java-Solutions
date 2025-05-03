package com.chandan.takeUforward.placementseries.MaximumSubarray53;

public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currSum + nums[i] > 0) {
                currSum += nums[i];
                maxSum = Math.max(maxSum, currSum);
            } else {
                currSum = 0;
                maxSum = Math.max(maxSum, nums[i]);
            }
        }
        return maxSum;
    }

    public int maxSubArray1(int[] nums) {
        int maxSum = nums[0], currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
            if(currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
}
