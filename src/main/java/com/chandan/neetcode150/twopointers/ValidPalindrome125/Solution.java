package com.chandan.neetcode150.twopointers.ValidPalindrome125;

public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            Character ch1 = s.charAt(i);
            Character ch2 = s.charAt(j);
            if(!isValid(ch1))
                i++;
            else if(!isValid(ch2))
                j--;
            else if(Character.toLowerCase(ch1) == Character.toLowerCase(ch2)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isValid(Character ch) {
        if(ch >= 'a' && ch <= 'z' ||
                ch >= 'A' && ch <= 'Z' ||
                ch >= '0' && ch <= '9')
            return true;
        return false;
    }
}
