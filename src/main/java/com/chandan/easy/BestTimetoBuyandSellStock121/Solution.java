package com.chandan.easy.BestTimetoBuyandSellStock121;

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, maxNum = 0;
        for(int i = prices.length - 1; i >= 0; i--) {
            if(prices[i] > maxNum) {
                maxNum = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, maxNum - prices[i]);
            }
        }
        return maxProfit;
    }
}
