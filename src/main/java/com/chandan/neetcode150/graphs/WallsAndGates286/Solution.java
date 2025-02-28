package com.chandan.neetcode150.graphs.WallsAndGates286;

import java.util.LinkedList;
import java.util.Queue;

/*
* You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example:

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
* */
public class Solution {

    public static void main(String[] args) {
        int[][] rooms = new int[][] {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0 , -1, Integer.MAX_VALUE, Integer.MAX_VALUE},
        };
        wallsAndGates(rooms);
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        int m = rooms.length;
        int n = rooms[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                if(rooms[i][j] == 0)
                    q.add(new int[]{i, j});
        }
        if(q.size() == 0)
            return;
        int[][] offsets = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };
        while(!q.isEmpty()) {
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
                    rooms[x][y] != Integer.MAX_VALUE)
                    continue;
                q.add(new int[] {x, y});
                rooms[x][y] = rooms[row][col] + 1;
            }
        }
    }
}
