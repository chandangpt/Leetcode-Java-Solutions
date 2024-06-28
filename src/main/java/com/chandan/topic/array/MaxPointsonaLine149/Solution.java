package com.chandan.topic.array.MaxPointsonaLine149;

import java.util.HashMap;

class Solution {
    public int maxPoints(int[][] points) {
        if(points.length <= 2)
            return points.length;
        int ans = 0;
        for(int i = 0; i < points.length; i++) {
            int duplicate = 0;
            HashMap<Double, Integer> map = new HashMap<>();
            for(int j = i + 1; j < points.length; j++) {
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    duplicate++;
                    continue;
                }
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                double slope = (dx == 0) ? 100000 : (dy == 0) ? 0 : ((double)dy) / ((double)dx);
                map.put(slope, map.getOrDefault(slope, 0) + 1);
            }
            for(int count : map.values()) {
                ans = Math.max(count + duplicate + 1, ans);
            }
        }
        return ans;
    }
}
