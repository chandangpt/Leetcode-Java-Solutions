package com.chandan.topic.array.BestTimetoBuyandSellStock121;

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(min > prices[i]) {
                min = prices[i];
            } else if(prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }
}