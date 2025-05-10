package com.chandan.takeUforward.placementseries.RotateImage48;

public class Solution {
    public void rotate(int[][] matrix) {
        //Transpose matrix
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //Reverse each row
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0, k = matrix[0].length - 1; j < k; j++, k--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
    }
}
