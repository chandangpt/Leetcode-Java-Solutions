package com.chandan.neetcode150.binarysearch.MedianOfTwoSortedArrays4;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n)
            return findMedianSortedArrays(nums2, nums1);
        int total = m + n;
        int half = (total + 1) / 2;
        int left = 0;
        int right = m;
        while(left <= right) {
            int middle1 = left + (right - left) / 2;
            int middle2 = half - middle1;
            int left1 = (middle1 > 0) ? nums1[middle1 - 1] : Integer.MIN_VALUE;
            int right1 = (middle1 < m) ? nums1[middle1] : Integer.MAX_VALUE;
            int left2 = (middle2 > 0) ? nums2[middle2 - 1] : Integer.MIN_VALUE;
            int right2 = (middle2 < n) ? nums2[middle2] : Integer.MAX_VALUE;
            if(left1 <= right2 && left2 <= right1) {
                if(total % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else
                    return Math.max(left1, left2);
            } else if(left1 > right2) {
                right = middle1 - 1;
            } else
                left = middle1 + 1;
        }
        return 0;
    }
}