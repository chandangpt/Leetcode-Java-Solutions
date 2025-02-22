package com.chandan.neetcode150.slidingwindow.MinimumWindowSubstring76;

import java.util.HashMap;

public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int matched = 0;
        int start = 0;
        int i = 0;
        int minLen = s.length() + 1;
        for(int j = 0; j < s.length(); j++) {
            Character ch = s.charAt(j);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) {
                    matched++;
                }
            }
            while(matched == map.size()) {
                if(minLen > j - i + 1) {
                    minLen = j - i + 1;
                    start = i;
                }
                char deleted = s.charAt(i++);
                if(map.containsKey(deleted)) {
                    if(map.get(deleted) == 0)
                        matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(start, start + minLen);
    }
}