package com.chandan.topic.array.SingleElementInASortedArray540;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 1, high = nums.length - 2, n = nums.length;
        if(n == 1 || nums[0] != nums[1])
            return nums[0];
        if(nums[n - 1] != nums[n - 2])
            return nums[n - 1];
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];
            if((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
                    (mid %2 == 1 && nums[mid] == nums[mid - 1])) {
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        return -1;
    }
}
