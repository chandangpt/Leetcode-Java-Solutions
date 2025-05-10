package com.chandan.takeUforward.placementseries.BestTimetoBuyandSellStock121;

public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = prices[0];
        for(int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}
