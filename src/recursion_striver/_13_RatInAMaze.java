package recursion_striver;

import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#
public class _13_RatInAMaze {
    public static void solve(int i, int j, int[][] maze, int size, boolean[][] visited, String path,
                             ArrayList<String> result) {
        // If we have reached the final element then we have to add path
        if (i == size - 1 && j == size - 1) {
            result.add(path);
            return;
        }

        // We follow lexographically (Alphabetically)
        // D - L - R - U
        // Can move to next block, is not visited and is 1 in maze
        // We mark current as visited before moving

        // Down
        if (i + 1 < size && visited[i + 1][j] == false && maze[i + 1][j] == 1) {
            visited[i][j] = true;
            solve(i + 1, j, maze, size, visited, path.concat("D"), result);
            visited[i][j] = false;
        }

        // Left
        if (j - 1 > -1 && visited[i][j - 1] == false && maze[i][j - 1] == 1) {
            visited[i][j] = true;
            solve(i, j - 1, maze, size, visited, path.concat("L"), result);
            visited[i][j] = false;
        }

        // Right
        if (j + 1 < size && visited[i][j + 1] == false && maze[i][j + 1] == 1) {
            visited[i][j] = true;
            solve(i, j + 1, maze, size, visited, path.concat("R"), result);
            visited[i][j] = false;
        }

        // Up
        if (i - 1 > -1 && visited[i - 1][j] == false && maze[i - 1][j] == 1) {
            visited[i][j] = true;
            solve(i - 1, j, maze, size, visited, path.concat("U"), result);
            visited[i][j] = false;
        }
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        boolean[][] visited = new boolean[n][n];
        String path = new String();
        ArrayList<String> result = new ArrayList<>();
        if (m[0][0] == 1) {
            solve(0, 0, m, n, visited, path, result);
        }
        return result;
    }
}
