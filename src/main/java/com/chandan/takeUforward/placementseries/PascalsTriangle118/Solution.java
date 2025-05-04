package com.chandan.takeUforward.placementseries.PascalsTriangle118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer> > ans = new ArrayList<List<Integer> >();
        List<Integer> curr, prev = null;
        for(int i = 0; i < numRows; i++) {
            curr = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i)
                    curr.add(1);
                else
                    curr.add(prev.get(j) + prev.get(j - 1));
            }
            prev = curr;
            ans.add(curr);
        }
        return ans;
    }
}
