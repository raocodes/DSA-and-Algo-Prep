package graphs_striver;

// https://leetcode.com/problems/number-of-islands/
public class _0_NumberOfIslands {
    public void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        dfs(i, j - 1, grid); // Left
        dfs(i, j + 1, grid); // Right
        dfs(i - 1, j, grid); // Up
        dfs(i + 1, j, grid); // Down
    }

    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(i, j, grid);
                }
            }
        }

        return islands;
    }
}
