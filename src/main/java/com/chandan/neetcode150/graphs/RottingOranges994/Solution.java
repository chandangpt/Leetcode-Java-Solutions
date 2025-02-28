package com.chandan.neetcode150.graphs.RottingOranges994;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                if(grid[i][j] == 2)
                    q.add(new int[]{i, j});
        }
        int[][] offsets = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };
        int time = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            boolean madeChange = false;
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int row = cur[0];
                int col = cur[1];
                for(int[] offset : offsets) {
                    int x = row + offset[0];
                    int y = col + offset[1];
                    if(x >= m ||
                            y >= n ||
                            x < 0 ||
                            y < 0 ||
                            grid[x][y] != 1)
                        continue;
                    madeChange = true;
                    q.add(new int[] {x, y});
                    grid[x][y] = 2;
                }
            }
            if(madeChange == true)
                time++;
        }
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] == 1)
                    return -1;
        return time;
    }
}
