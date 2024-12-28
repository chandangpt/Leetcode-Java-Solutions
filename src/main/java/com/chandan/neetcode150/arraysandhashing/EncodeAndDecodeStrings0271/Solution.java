package com.chandan.neetcode150.arraysandhashing.EncodeAndDecodeStrings0271;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for(String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString();
    }

    public static List<String> decode(String str) {
        List<String> decodedString = new ArrayList<>();
        for(int i = 0; i < str.length(); ) {
            Character ch = str.charAt(i);
            if(ch >= '1' && ch <= '9' && (i + 1 < str.length()) && str.charAt(i + 1) == '#') {
                int len = ch - '0';
                i += 2;
                StringBuilder newStr = new StringBuilder();
                while(len != 0) {
                    newStr.append(str.charAt(i++));
                    len--;
                }
                decodedString.add(newStr.toString());
            }
        }
        return decodedString;
    }

    public static void main(String[] args) {
        String encodedString = encode(Arrays.asList("neet","code","love","you"));
        List<String> decodedString = decode(encodedString);
        for(String str : decodedString) {
            System.out.println(str);
        }
    }
}
