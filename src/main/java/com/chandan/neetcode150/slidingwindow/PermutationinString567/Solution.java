package com.chandan.neetcode150.slidingwindow.PermutationinString567;

import java.util.Arrays;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int[] freq1 = new int[26];
        int n = s2.length();
        int[] freq2 = new int[26];
        for(int i = 0; i < m; i++)
            freq1[s1.charAt(i) - 'a']++;
        for(int i = 0; i < n; i++) {
            freq2[s2.charAt(i) - 'a']++;
            if(i >= m)
                freq2[s2.charAt(i - m) - 'a']--;
            if(Arrays.equals(freq1, freq2))
                return true;
        }
        return false;
    }
}
