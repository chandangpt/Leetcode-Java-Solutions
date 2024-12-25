package com.chandan.neetcode150.arraysandhashing.ContainsDuplicate217;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(!uniqueNums.contains(nums[i]))
                uniqueNums.add(nums[i]);
            else
                return true;
        }
        return false;
    }
}
