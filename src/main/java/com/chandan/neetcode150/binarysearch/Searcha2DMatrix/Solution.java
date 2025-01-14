package com.chandan.neetcode150.binarysearch.Searcha2DMatrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(matrix[mid][n - 1] == target)
                return true;
            else if(matrix[mid][n - 1] < target)
                low = mid + 1;
            else
                high = mid;
        }
        int row = high;
        low = 0;
        high = n - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(matrix[row][mid] == target)
                return true;
            else if(matrix[row][mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}
