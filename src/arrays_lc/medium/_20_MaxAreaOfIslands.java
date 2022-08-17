package arrays_lc.medium;

// https://leetcode.com/problems/max-area-of-island/
public class _20_MaxAreaOfIslands {
    public int findIsland(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid[0].length || y < 0 || y >= grid.length || grid[y][x] == 0) {
            return 0;
        }

        grid[y][x] = 0;
        int result = 1;

        result += findIsland(x - 1, y, grid); // Left
        result += findIsland(x + 1, y, grid); // Right
        result += findIsland(x, y - 1, grid); // Up
        result += findIsland(x, y + 1, grid); // Down

        return result;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(findIsland(j, i, grid), max);
                }
            }
        }
        return max;
    }
}
