package com.chandan.takeUforward.placementseries.SetMatrixZeroes73;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean rowZero = false, colZero = false;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                if(matrix[i][j] == 0) {
                    if(i == 0)
                        rowZero = true;
                    if(j == 0)
                        colZero = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(colZero == true)
            for(int i = 0; i < m; i++)
                matrix[i][0] = 0;
        if(rowZero == true)
            for(int i = 0; i < n; i++)
                matrix[0][i] = 0;
    }

    public void setZeroes1(int[][] matrix) {
        Set<Integer> rowZero = new HashSet<>();
        Set<Integer> colZero = new HashSet<>();
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                if(matrix[i][j] == 0) {
                    rowZero.add(i);
                    colZero.add(j);
                }
        }
        for(int row : rowZero) {
            for(int i = 0; i < n; i++)
                matrix[row][i] = 0;
        }
        for(int col : colZero) {
            for(int i = 0; i < m; i++)
                matrix[i][col] = 0;
        }
    }
}
