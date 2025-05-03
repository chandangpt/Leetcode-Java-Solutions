package com.chandan.takeUforward.placementseries.MergeIntervals56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        ans.add(intervals[i]);
        for(i = 1; i < n; i++) {
            int[] top = ans.get(ans.size() - 1);
            if(top[1] >= intervals[i][0]) {
                int max = Math.max(top[1],intervals[i][1]);
                //ans.remove(ans.size() - 1);
                //ans.add(new int[]{top[0], max});
                top[1] = max;
            } else {
                ans.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        int[][] overlappedIntv = new int[ans.size()][];
        for(i = 0; i < ans.size(); i++)
            overlappedIntv[i] = ans.get(i);
        return overlappedIntv;
    }
}
