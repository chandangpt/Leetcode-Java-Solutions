package com.chandan.neetcode150.slidingwindow.LongestSubstringWithoutRepeatingCharacters3;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        //return usingSet(s);
        return usingMap(s);
    }

    public int usingSet(String s) {
        HashSet<Character> set = new HashSet<>();
        int j = 0, maxLen = 0;
        for(int i = 0; i < s.length(); i++) {
            while(set.contains(s.charAt(i)))
                set.remove(s.charAt(j++));
            set.add(s.charAt(i));
            maxLen= Math.max(maxLen, i - j + 1);
        }
        return maxLen;
    }

    public int usingMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int j = 0, maxLen = 0;
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while(map.get(s.charAt(i)) > 1) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                j++;
            }
            maxLen= Math.max(maxLen, i - j + 1);
        }
        return maxLen;
    }
}
