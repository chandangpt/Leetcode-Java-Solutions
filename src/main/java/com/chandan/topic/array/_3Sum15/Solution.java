package com.chandan.topic.array._3Sum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer> > ans = new ArrayList<List<Integer> >();
        HashSet<List<Integer> > set = new HashSet<>();
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1, k = nums.length - 1;j < k;) {
                if(nums[i] + nums[j] + nums[k] < 0)
                    j++;
                else if(nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    set.add(triplet);
                    k--;
                    j++;
                }
            }
        }
        ans.addAll(set);
        return ans;
    }

    public List<List<Integer>> threeSumOptimize(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer> > ans = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0)
                break;
            if(i > 0 && nums[i] == nums[i - 1]) // Discarding duplicates
                continue;
            for(int j = i + 1, k = nums.length - 1;j < k;) {
                if(nums[i] + nums[j] + nums[k] < 0)
                    j++;
                else if(nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    ans.add(triplet);
                    int lastLowOccurrence = nums[j];
                    int lastHighOccurrence = nums[k];
                    while(k > j && nums[k] == lastHighOccurrence)  // Discarding duplicates
                        k--;
                    while(k > j && nums[j] == lastLowOccurrence)   // Discarding duplicates
                        j++;
                }
            }
        }
        return ans;
    }
}