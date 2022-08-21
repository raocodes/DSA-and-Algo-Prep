package companyot.moveworks;

public class Assasin {
    boolean dfs(int[][] board, boolean[][] visited, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] == 1) {
            return false;
        }

        visited[i][j] = true;

        if (i == m - 1 && j == n - 1) {
            // Reached bottom right
            return true;
        }

        boolean up = dfs(board, visited, i - 1, j, m, n);
        boolean down = dfs(board, visited, i + 1, j, m, n);
        boolean left = dfs(board, visited, i, j - 1, m, n);
        boolean right = dfs(board, visited, i, j + 1, m, n);

        return up || down || left || right;
    }

    public boolean solution(String[] B) {
        int m = B.length;
        int n = B[0].length();

        int starti = -1;
        int startj = -1;

        int[][] board = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (B[i].charAt(j) == 'X') {
                    board[i][j] = 1;
                } else if (B[i].charAt(j) == '>') {
                    board[i][j] = 1;
                    for (int k = j + 1; k < n; k++) {
                        if (B[i].charAt(k) == 'A') {
                            return false;
                        }
                        if (B[i].charAt(k) != '.') {
                            break;
                        }
                        board[i][k] = 1;
                    }
                } else if (B[i].charAt(j) == '^') {
                    board[i][j] = 1;
                    for (int k = i - 1; k >= 0; k--) {
                        if (B[k].charAt(j) == 'A') {
                            return false;
                        }
                        if (B[k].charAt(j) != '.') {
                            break;
                        }
                        board[k][j] = 1;
                    }
                } else if (B[i].charAt(j) == '<') {
                    board[i][j] = 1;
                    for (int k = j - 1; k >= 0; k--) {
                        if (B[i].charAt(k) == 'A') {
                            return false;
                        }
                        if (B[i].charAt(k) != '.') {
                            break;
                        }
                        board[i][k] = 1;
                    }
                } else if (B[i].charAt(j) == 'v') {
                    board[i][j] = 1;
                    for (int k = i + 1; k < m; k++) {
                        if (B[k].charAt(j) == 'A') {
                            return false;
                        }
                        if (B[k].charAt(j) != '.') {
                            break;
                        }
                        board[k][j] = 1;
                    }
                } else if (B[i].charAt(j) == '.') {
                    continue;
                } else if (B[i].charAt(j) == 'A') {
                    starti = i;
                    startj = j;
                }
            }
        }

        boolean result = dfs(board, visited, starti, startj, m, n);
        return result;
    }
}
