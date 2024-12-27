package com.chandan.neetcode150.arraysandhashing.LongestConsecutiveSequence128;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums)
            numSet.add(num);
        int maxLen = 0;
        for(int num : nums) {
            int len = 0;
            if(!numSet.contains(num - 1)) {
                while(numSet.contains(num)) {
                    len++;
                    num++;
                }
                if(maxLen < len){
                    maxLen = len;
                }
            }
            if(maxLen > nums.length / 2)
                return maxLen;
        }
        return maxLen;
    }
}
