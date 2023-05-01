package striver_og.recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/n-queens/
public class _9_NQueens {
    public boolean isAllowed(char[][] board, int row, int column) {
        // We need to check only 3 directions
        // Left, top left, bottom left
        // We do no need to check up and down because for each column only one is
        // chosen]
        // We do not go to the right as we are going column to column
        // There are no elements to the right to check!

        // Here each check takes O(N)!!!

        // NOT USED IN SECOND APPROACH

        int temprow;
        int tempcol;

        // Top left
        temprow = row;
        tempcol = column;
        while (temprow >= 0 && tempcol >= 0) {
            if (board[temprow][tempcol] == 'Q') {
                return false;
            }
            temprow--;
            tempcol--;
        }

        // Bottom left
        temprow = row;
        tempcol = column;
        while (temprow <= board.length - 1 && tempcol >= 0) {
            if (board[temprow][tempcol] == 'Q') {
                return false;
            }
            temprow++;
            tempcol--;
        }

        // Left
        temprow = row;
        tempcol = column;
        while (tempcol >= 0) {
            if (board[temprow][tempcol] == 'Q') {
                return false;
            }
            tempcol--;
        }

        return true;
    }

    public void solve(int column, char[][] board, List<List<String>> result) {
        if (column == board.length) {
            // We need to add the current layout into the result
            List<String> toadd = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                toadd.add(new String(board[i]));
            }
            result.add(toadd);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isAllowed(board, row, column)) {
                board[row][column] = 'Q';
                solve(column + 1, board, result);
                board[row][column] = '.'; // Reset after backtracking
            }
        }
    }

    public void solveEfficient(int column, char[][] board, List<List<String>> result, boolean[] lowerDiagonal,
                               boolean[] upperDiagonal, boolean[] left) {
        if (column == board.length) {
            // We need to add the current layout into the result
            List<String> toadd = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                toadd.add(new String(board[i]));
            }
            result.add(toadd);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (!lowerDiagonal[row + column] && !upperDiagonal[board.length - 1 + column - row] && !left[row]) {
                board[row][column] = 'Q';
                lowerDiagonal[row + column] = true;
                upperDiagonal[board.length - 1 + column - row] = true;
                left[row] = true;
                solveEfficient(column + 1, board, result, lowerDiagonal, upperDiagonal, left);
                // Reset after backtracking
                board[row][column] = '.';
                lowerDiagonal[row + column] = false;
                upperDiagonal[board.length - 1 + column - row] = false;
                left[row] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        // Setting initial value of '.' in the board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        boolean[] lowerDiagonal = new boolean[2 * n - 1];
        boolean[] upperDiagonal = new boolean[2 * n - 1];
        boolean[] left = new boolean[n];
        solveEfficient(0, board, result, lowerDiagonal, upperDiagonal, left);
        return result;
    }
}
