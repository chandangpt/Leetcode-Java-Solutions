package com.chandan.topic.bfs.NumberOfIslands200;

class Solution {
    public int numIslands(char[][] grid) {
        int numOfIsland = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    bfs(grid, i, j);
                    numOfIsland++;
                }
            }
        }
        return numOfIsland;
    }

    public void bfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        if(grid[i][j] == '1') {
            grid[i][j] = '2';
            bfs(grid, i - 1, j);
            bfs(grid, i + 1, j);
            bfs(grid, i , j + 1);
            bfs(grid, i, j - 1);
        }
    }
}
