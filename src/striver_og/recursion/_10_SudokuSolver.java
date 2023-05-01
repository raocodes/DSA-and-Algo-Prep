package striver_og.recursion;

// https://leetcode.com/problems/sudoku-solver/
public class _10_SudokuSolver {
    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    // Found an empty cell
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            boolean result = solve(board);
                            // If result is false,
                            // It means that it could not solve with what we have chosen
                            // Therefore we reset it
                            // If it is true,
                            // Then we have reached the base condition
                            // This means everything is solved and so we return true.
                            if (result == true) {
                                return true;
                                // Tell the parent call that it is solved
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    // If code reached here, loop ended without returning a true
                    // That means the puzzle was not solved and loop came out
                    // No possible values found so we must backtrack
                    return false;
                }
            }
        }
        // Base condition is when there are no empty left
        // That is only possible if it exists the for loop
        return true;
    }

    public boolean isValid(char[][] board, int row, int column, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                // Checking the current row for the value
                return false;
            }

            if (board[i][column] == num) {
                // Checking the current column for the value
                return false;
            }

            int subboxrow = 3 * (row / 3) + i / 3;
            int subboxcolumn = 3 * (column / 3) + i % 3;

            if (board[subboxrow][subboxcolumn] == num) {
                // Checking the 3x3 sub-box for the value
                return false;
            }
        }
        // If it exited the loop then it is surely valid
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
