package com.chandan.companywise.servicenow;

public class CherryPickup741 {
    public int cherryPickUtil(int row1, int col1, int row2, int[][] grid, Integer[][][] dp) {
        int col2 = row1 + col1 - row2;
        if(row1 >= grid.length ||
                row2 >= grid.length ||
                col1 >= grid.length ||
                col2 >= grid.length ||
                grid[row1][col1] == -1 ||
                grid[row2][col2] == -1)
            return Integer.MIN_VALUE;
        if(row1 == grid.length - 1 && col1 == grid.length - 1)
            return grid[row1][col1];
        if(dp[row1][col1][row2] != null)
            return dp[row1][col1][row2];
        int cherries = 0;
        if(row1 == row2 && col1 == col2)
            cherries += grid[row1][col1];
        else
            cherries += grid[row1][col1] + grid[row2][col2];
        int f1 = cherryPickUtil(row1, col1 + 1, row2, grid, dp);
        int f2 = cherryPickUtil(row1 + 1, col1, row2, grid, dp);
        int f3 = cherryPickUtil(row1 + 1, col1, row2 + 1, grid, dp);
        int f4 = cherryPickUtil(row1, col1 + 1, row2 + 1, grid, dp);
        cherries += Math.max(f1, Math.max(f2, Math.max(f3, f4)));
        dp[row1][col1][row2] = cherries;
        return cherries;
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        Integer[][][] dp = new Integer[n][n][n];
        int ans = cherryPickUtil(0,0,0,grid,dp);
        return ans > 0 ? ans : 0;
    }
}
