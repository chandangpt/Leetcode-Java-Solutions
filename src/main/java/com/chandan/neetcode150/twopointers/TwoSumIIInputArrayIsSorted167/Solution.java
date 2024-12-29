package com.chandan.neetcode150.twopointers.TwoSumIIInputArrayIsSorted167;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0, j = numbers.length - 1; i < j;) {
            if(numbers[i] + numbers[j] == target)
                return new int[]{i + 1, j + 1};
            if(numbers[i] + numbers[j] < target)
                i++;
            else
                j--;
        }
        return new int[]{};
    }
}
