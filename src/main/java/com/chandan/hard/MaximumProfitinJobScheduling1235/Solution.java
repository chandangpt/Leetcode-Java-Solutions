package com.chandan.hard.MaximumProfitinJobScheduling1235;

import java.util.Arrays;
import java.util.TreeMap;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for(int i = 0; i < startTime.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b)-> a[1] - b[1]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        for(int[] job : jobs) {
            int val = job[2] + map.floorEntry(job[0]).getValue();
            if(val > map.lastEntry().getValue()) {
                map.put(job[1], val);
            }
        }
        return map.lastEntry().getValue();
    }
}
