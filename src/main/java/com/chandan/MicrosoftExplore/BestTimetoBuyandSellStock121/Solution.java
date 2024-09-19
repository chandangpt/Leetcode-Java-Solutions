package com.chandan.MicrosoftExplore.BestTimetoBuyandSellStock121;

public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, currMin = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < currMin) {
                currMin = prices[i];
            } else if(prices[i] - currMin > maxProfit)
                maxProfit = prices[i] - currMin;
        }
        return maxProfit;
    }
}
