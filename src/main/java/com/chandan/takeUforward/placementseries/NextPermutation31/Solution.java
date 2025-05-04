package com.chandan.takeUforward.placementseries.NextPermutation31;

public class Solution {
    public void nextPermutation(int[] nums) {
        int index;
        for (index = nums.length - 2; index >= 0; index--) {
            if (nums[index] < nums[index + 1])
                break;
        }
        if (index != -1) {
            int i;
            for (i = index + 1; i < nums.length; i++) {
                if (nums[index] >= nums[i])
                    break;
            }
            int temp = nums[i - 1];
            nums[i - 1] = nums[index];
            nums[index] = temp;
        }
        for (int j = index + 1, k = nums.length - 1; j < k; j++, k--) {
            int temp = nums[j];
            nums[j] = nums[k];
            nums[k] = temp;
        }
    }
}
