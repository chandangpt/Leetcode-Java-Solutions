package com.chandan.topic.array.TwoSum1;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> store = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(store.containsKey(target-nums[i]))
                return new int[]{i, store.get(target-nums[i])};
            else
                store.put(nums[i], i);
        }
        return new int[]{};
    }
}
