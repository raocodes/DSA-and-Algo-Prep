package striver_sheet.stacksandqueues_ii;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/rotting-oranges/

class Orange {
    int i;
    int j;

    Orange(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class _7_RottingOranges {
    public int orangesRotting(int[][] grid) {
        // First we count the number of non-empty cells
        // We are going to do a BFS traversal, so we use queue
        // In the queue we store i,j
        // When we start out we add all the already rotten oranges into the queue

        int nonempty = 0;

        Queue<Orange> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Orange(i, j));
                    nonempty++;
                } else if (grid[i][j] == 1) {
                    nonempty++;
                }
            }
        }

        if (nonempty == 0) {
            return 0;
        }

        // We take from the queue and then try to go to all the directions
        // If in one of the directions has a node we consider it rotten then add to the
        // queue

        int[] xdirection = new int[]{0, 0, 1, -1};
        int[] ydirection = new int[]{1, -1, 0, 0};

        int days = 0;
        int totalvisited = 0;
        while (!queue.isEmpty()) {
            int currsize = queue.size();
            totalvisited += currsize;
            for (int i = 0; i < currsize; i++) {
                Orange org = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = org.i + xdirection[j];
                    int y = org.j + ydirection[j];

                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 2 || grid[x][y] == 0)
                        continue;

                    grid[x][y] = 2;
                    queue.offer(new Orange(x, y));
                }
            }
            days++;
        }

        if (totalvisited != nonempty) {
            return -1;
        }
        return days - 1;
    }
}
