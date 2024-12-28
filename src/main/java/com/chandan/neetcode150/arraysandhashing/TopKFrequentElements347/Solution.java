package com.chandan.neetcode150.arraysandhashing.TopKFrequentElements347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(int key : countMap.keySet()) {
            int count = countMap.get(key);
            if(bucket[count] == null)
                bucket[count] = new ArrayList<>();
            bucket[count].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for(int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if(bucket[i] != null)
                res.addAll(bucket[i]);
        }
        int[] resArr = new int[res.size()];
        int i = 0;
        for(int elem : res)
            resArr[i++] = elem;
        return resArr;
    }
}