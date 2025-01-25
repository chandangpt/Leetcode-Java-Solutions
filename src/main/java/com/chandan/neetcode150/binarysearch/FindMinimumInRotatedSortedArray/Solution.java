package com.chandan.neetcode150.binarysearch.FindMinimumInRotatedSortedArray;

public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[n - 1])
                low = mid + 1;
            else if(mid == 0 || nums[mid] < nums[mid - 1])
                return nums[mid];
            else
                high = mid;
        }
        return -1;
    }
}
