package com.chandan.interviewexperience.salesforce;

import java.util.ArrayList;
import java.util.List;
/*
Given a 2D matrix of dimension m✕n, the task is to print all the possible paths from the top left corner to the bottom right corner in a 2D matrix with the constraints that from each cell you can either move to right or down only.

Examples :

Input: [[1,2,3],
[4,5,6]]
Output: [[1,4,5,6],
[1,2,5,6],
[1,2,3,6]]

Input: [[1,2],
[3,4]]
Output: [[1,2,4],
[1,3,4]]
*/

public class PrintAllPossiblePathsFromTopLeftToBottomRightInMatrix {
    private static int row, col;
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> path = new ArrayList<>();
        row = arr.length;
        col = arr[0].length;
        findPaths(arr, path, 0, 0);
    }

    private static void findPaths(int[][] arr, List<Integer> path, int i, int j) {
        if(i == row - 1 && j == col - 1) {
            path.add(arr[i][j]);
            printPath(path);
            path.remove(path.size() - 1);
            return;
        }
        if(i < 0 || j < 0 || i >= row || j >= col) {
            return;
        }
        path.add(arr[i][j]);
        if(j + 1 < col) {
            findPaths(arr, path, i, j + 1);
        }
        if(i + 1 < row) {
            findPaths(arr, path, i + 1, j);
        }
        path.remove(path.size() - 1);
    }

    private static void printPath(List<Integer> path) {
        for(int i : path) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
