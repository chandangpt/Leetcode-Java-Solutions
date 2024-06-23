package com.chandan.topic.array.MergeIntervals56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> ans = new LinkedList<int[]>();
        for(int[] interval : intervals) {
            if(ans.isEmpty() || ans.getLast()[1]  < interval[0])
                ans.add(interval);
            else
                ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
        }
        return ans.toArray(new int[ans.size()][]);
    }
    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int m = intervals.length;
        ArrayList<int[]> ans = new ArrayList<>();
        int k = 0;
        for(int i = 0; i < m; i++) {
            if(ans.isEmpty() || intervals[i][0] > ans.get(k - 1)[1]) {
                ans.add(new int[]{intervals[i][0], intervals[i][1]});
                k++;
            }
            else {
                int[] temp = ans.remove(k - 1);
                temp[1] = Math.max(intervals[i][1], temp[1]);
                ans.add(temp);
            }
        }
        int[][] result = new int[k][2];
        int i = 0;
        for(int[] pair : ans) {
            result[i][0] = pair[0];
            result[i++][1] = pair[1];
        }
        return result;
    }
}
