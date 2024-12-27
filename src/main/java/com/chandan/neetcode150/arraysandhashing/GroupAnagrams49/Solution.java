package com.chandan.neetcode150.arraysandhashing.GroupAnagrams49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String> > anagramGrp = new HashMap<>();
        for(String str : strs) {
            char[] word = str.toCharArray();
            Arrays.sort(word);
            String sortedWord = new String(word);
            List<String> anagrams;
            if(!anagramGrp.containsKey(sortedWord)) {
                anagrams = new ArrayList<>();
            } else {
                anagrams = anagramGrp.get(sortedWord);
            }
            anagrams.add(str);
            anagramGrp.put(sortedWord, anagrams);
        }
        return new ArrayList<>(anagramGrp.values());
    }
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String> > anagramGrp = new HashMap<>();
        for(String str : strs) {
            int count[] = new int[26];
            for(int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            List<String> anagrams;
            if(!anagramGrp.containsKey(key)) {
                anagrams = new ArrayList<>();
            } else {
                anagrams = anagramGrp.get(key);
            }
            anagrams.add(str);
            anagramGrp.put(key, anagrams);
        }
        return new ArrayList<>(anagramGrp.values());
    }
}
