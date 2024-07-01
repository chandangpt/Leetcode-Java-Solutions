package com.chandan.topic.array.MinimumRoundstoCompleteAllTasks2244;

import java.util.HashMap;

class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0; i < tasks.length; i++)
            countMap.put(tasks[i], countMap.getOrDefault(tasks[i], 0) + 1);
        int ans = 0;
        for(int count : countMap.values()) {
            if(count == 1)
                return -1;
            else
                ans += count / 3;
            if((count % 3) != 0)
                ans++;
        }
        return ans;
    }
}
