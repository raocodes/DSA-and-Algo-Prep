package arrays_lc.medium;

// https://leetcode.com/problems/game-of-life/
public class _12_GameOfLife {
    private int live(int[][] board, int i, int j) {
        int count = 0;

        if (j > 0) {
            if (board[i][j - 1] == 1 || board[i][j - 1] == 11) count++; // Left
            if (i < board.length - 1 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 11)) count++; // Left-Down
            if (i > 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 11)) count++; // Left-Up
        }

        if (i > 0 && (board[i - 1][j] == 1 || board[i - 1][j] == 11)) count++; // Up
        if (i < board.length - 1 && (board[i + 1][j] == 1 || board[i + 1][j] == 11)) count++; // Down

        if (j < board[0].length - 1) {
            if (board[i][j + 1] == 1 || board[i][j + 1] == 11) count++; // Right
            if (i < board.length - 1 && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 11)) count++; // Right-Down
            if (i > 0 && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 11)) count++; // Right-Up
        }

        return count;
    }

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 10 means it is a 0 that is to be turned into a 1
                // 11 means it is a 1 that has to be turned into a 0
                // 0 means it is a 0 that has to be a 0 only
                // 1 means it is a 1 that has to stay a 1 only
                if (board[i][j] == 0) {
                    board[i][j] = live(board, i, j) == 3 ? 10 : 0;
                    // If it has 3 live neighbours so needs to be brought alive
                } else {
                    int liveNeighbours = live(board, i, j);
                    board[i][j] = liveNeighbours >= 2 && liveNeighbours <= 3 ? 1 : 11;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 10) {
                    board[i][j] = 1;
                } else if (board[i][j] == 11) {
                    board[i][j] = 0;
                }
            }
        }
    }
}
