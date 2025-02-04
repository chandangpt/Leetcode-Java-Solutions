package com.chandan.neetcode150.binarysearch.KokoEatingBananas875;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for(int pile : piles)
            right = Math.max(pile, right);
        while(left < right) {
            int middle = left + (right - left) / 2;
            int totalTime = 0;
            for(int pile : piles)
                totalTime += Math.ceil((double)pile / middle);
            if(totalTime <= h)
                right = middle;
            else
                left = middle + 1;
        }
        return right;
    }
}
