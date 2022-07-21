package striver_sheet.dynamicprogramming_ii;

import java.util.Arrays;

// https://www.codingninjas.com/codestudio/problems/job-sequencing-problem_1169460?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class _8_JobSequencingProblem {
    static int[][] dp = new int[3001][100001];

    public static int findMaxProfit(int index, int[][] jobs, int time) {
        if (index == 0) {
            return 0;
        }

        if (dp[index][time] != -1) {
            return dp[index][time];
        }

        if (jobs[index - 1][0] >= time) {
            return dp[index][time] = Math.max(jobs[index - 1][1] + findMaxProfit(index - 1, jobs, time + 1),
                    findMaxProfit(index - 1, jobs, time));
        } else {
            return dp[index][time] = findMaxProfit(index - 1, jobs, time);
        }
    }

    public static int jobScheduling(int[][] jobs) {
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        Arrays.sort(jobs, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return 1;
            } else if (o1[0] > o2[0]) {
                return -1;
            } else {
                return 0;
            }
        });
        return findMaxProfit(jobs.length, jobs, 1);
    }
}
