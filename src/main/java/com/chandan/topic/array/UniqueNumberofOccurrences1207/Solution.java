package com.chandan.topic.array.UniqueNumberofOccurrences1207;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : arr)
            map.put(num, map.getOrDefault(num, 0) + 1);
        HashSet<Integer> uniqueCount = new HashSet<>();
        for(int count : map.values())
            uniqueCount.add(count);
        return uniqueCount.size() == map.size();
    }
}
