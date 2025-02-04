package com.chandan.neetcode150.slidingwindow.BestTimetoBuyandSellStock121;

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int maxSoFar = prices[len - 1];
        int maxProfit = 0;
        for(int i = len - 2; i >= 0; i--) {
            if(prices[i] > maxSoFar)
                maxSoFar = prices[i];
            else
                maxProfit = Math.max(maxProfit, maxSoFar - prices[i]);
        }
        return maxProfit;
    }
}