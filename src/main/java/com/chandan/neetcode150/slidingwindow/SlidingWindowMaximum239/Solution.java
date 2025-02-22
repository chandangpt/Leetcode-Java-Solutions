package com.chandan.neetcode150.slidingwindow.SlidingWindowMaximum239;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int max[] = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int j = 0;
        for(int i = 0; i < n; i++) {
            if(!q.isEmpty() && q.peekFirst() < i - k + 1)
                q.pollFirst();
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.pollLast();
            q.offer(i);
            if(i >= k - 1)
                max[j++] = nums[q.peekFirst()];
        }
        return max;
    }
}
