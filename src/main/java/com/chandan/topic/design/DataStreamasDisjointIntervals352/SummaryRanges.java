package com.chandan.topic.design.DataStreamasDisjointIntervals352;

import java.util.Map;
import java.util.TreeMap;

class SummaryRanges {
    TreeMap<Integer, int[]> tree;

    public SummaryRanges() {
        tree = new TreeMap<>();
    }

    public void addNum(int value) {
        if(tree.containsKey(value))
            return;
        Integer low = tree.lowerKey(value);
        Integer high = tree.higherKey(value);
        if(low != null &&
                high != null &&
                ((tree.get(low)[1]) + 1 == value) &&
                (high == value + 1)) {
            tree.get(low)[1] = tree.get(high)[1];
            tree.remove(high);
        } else if(low != null && tree.get(low)[1] + 1 >= value) {
            tree.get(low)[1] = Math.max(tree.get(low)[1], value);
        } else if(high != null && high == value + 1) {
            tree.put(value, new int[]{value, tree.get(high)[1]});
            tree.remove(high);
        } else {
            tree.put(value, new int[]{value, value});
        }
    }

    public int[][] getIntervals() {
        int[][] intervals = new int[tree.size()][];
        int i = 0;
        for(Map.Entry<Integer,int[]> entry : tree.entrySet()) {
            intervals[i] = entry.getValue();
            i++;
        }
        return intervals;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
