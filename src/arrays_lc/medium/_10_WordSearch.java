package arrays_lc.medium;

// https://leetcode.com/problems/word-search/
public class _10_WordSearch {
    public boolean dfs(boolean[][] visited, int x, int y, char[][] board, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (x < 0 || x >= board[0].length || y < 0 || y >= board.length || visited[y][x] || word.charAt(index) != board[y][x]) {
            return false;
        }

        visited[y][x] = true;

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            if (dfs(visited, x + direction[0], y + direction[1], board, word, index + 1)) {
                return true;
            }
        }

        visited[y][x] = false;

        return false;
    }


    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(visited, j, i, board, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
