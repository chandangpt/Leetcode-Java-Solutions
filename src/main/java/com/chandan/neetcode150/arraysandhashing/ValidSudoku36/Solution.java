package com.chandan.neetcode150.arraysandhashing.ValidSudoku36;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // if (!isValidRow(board) || !isValidCol(board))
        // return false;
        if (!isValidRowCol(board)) // Optimise traversals
            return false;
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidBox(board, i, i + 3, j, j + 3))
                    return false;
            }
        }
        /*
         * if (!isValidDiagonal(board))
         * return false;
         * if (!isValidAntiDiagonal(board))
         * return false;
         */
        return true;
    }

    boolean isValidRowCol(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rowElems = new HashSet<>();
            Set<Character> colElems = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    if (rowElems.contains(board[i][j]))
                        return false;
                    else
                        rowElems.add(board[i][j]);
                } else if (board[i][j] != '.') {
                    return false;
                }
                if (board[j][i] >= '1' && board[j][i] <= '9') {
                    if (colElems.contains(board[j][i]))
                        return false;
                    else
                        colElems.add(board[j][i]);
                } else if (board[j][i] != '.') {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValidDiagonal(char[][] board) {
        int[] count = new int[9];
        for (int i = 0; i < 9; i++) {
            if (board[i][i] >= '1' && board[i][i] <= '9') {
                if (count[board[i][i] - '1'] != 0)
                    return false;
                count[board[i][i] - '1']++;
            } else if (board[i][i] != '.') {
                return false;
            }
        }
        return true;
    }

    boolean isValidAntiDiagonal(char[][] board) {
        int[] count = new int[9];
        for (int i = 0; i < 9; i++) {
            int col = 8 - i;
            if (board[i][col] >= '1' && board[i][col] <= '9') {
                if (count[board[i][col] - '1'] != 0)
                    return false;
                count[board[i][col] - '1']++;
            } else if (board[i][col] != '.') {
                return false;
            }
        }
        return true;
    }

    boolean isValidBox(char[][] board, int rowStart, int rowEnd, int colStart, int colEnd) {
        int[] count = new int[9];
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    if (count[board[i][j] - '1'] != 0)
                        return false;
                    count[board[i][j] - '1']++;
                } else if (board[i][j] != '.') {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValidRow(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] count = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    if (count[board[i][j] - '1'] != 0)
                        return false;
                    count[board[i][j] - '1']++;
                } else if (board[i][j] != '.') {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValidCol(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] count = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] >= '1' && board[j][i] <= '9') {
                    if (count[board[j][i] - '1'] != 0)
                        return false;
                    count[board[j][i] - '1']++;
                } else if (board[j][i] != '.') {
                    return false;
                }
            }
        }
        return true;
    }
}
