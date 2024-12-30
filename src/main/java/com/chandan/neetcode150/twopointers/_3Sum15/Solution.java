package com.chandan.neetcode150.twopointers._3Sum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0)
                break;
            if(i > 0 && nums[i - 1] == nums[i])
                continue;
            for(int j = i + 1, k = nums.length - 1; j < k;) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    ans.add(triplet);
                    while(j < k && nums[j] == nums[j + 1])
                        j++;
                    while(j < k && nums[k] == nums[k - 1])
                        k--;
                    j++;
                    k--;
                } else if(sum > 0)
                    k--;
                else
                    j++;
            }
        }
        return ans;
    }
}
