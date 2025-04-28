package com.chandan.takeUforward.placementseries.UniquePaths62;

public class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                dp[i][j] = -1;
        return uniquePathsUtil(m, n, 0, 0, dp);
    }

    int uniquePathsUtil(int m, int n, int i, int j, int dp[][]) {
        if(i >= m || j >= n || i < 0 || j < 0) {
            return 0;
        }
        if(dp[i][j] != -1)
            return dp[i][j];
        if(i == m - 1 && j == n - 1)
            return 1;
        dp[i][j] =  uniquePathsUtil(m, n, i + 1, j, dp) + uniquePathsUtil(m, n, i, j + 1, dp);
        return dp[i][j];
    }
}