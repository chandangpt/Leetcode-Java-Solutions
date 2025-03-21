package com.chandan.topic.array.MedianofTwoSortedArrays4;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n)
            return findMedianSortedArrays(nums2, nums1);
        int total = m + n;
        int leftSize = (total + 1) / 2;
        int low = 0;
        int high = m;
        while(low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = leftSize - mid1;
            int right1 = (mid1 < m) ? nums1[mid1] : Integer.MAX_VALUE;
            int right2 = (mid2 < n) ? nums2[mid2] : Integer.MAX_VALUE;
            int left1 = (mid1 - 1 >= 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int left2 = (mid2 - 1 >= 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            if(left1 <= right2 && left2 <= right1) {
                if(total % 2 == 1)
                    return Math.max(left1, left2);
                else
                    return (double) (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if(left1 > right2) {
                high = mid1 - 1;
            } else
                low = mid1 + 1;
        }
        return 0;
    }
}
