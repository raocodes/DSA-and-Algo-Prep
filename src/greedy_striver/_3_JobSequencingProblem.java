package greedy_striver;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#
public class _3_JobSequencingProblem {
    class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (o1, o2) -> {
            return o2.profit - o1.profit;
        });

        int deadline = Integer.MIN_VALUE;
        for (Job job : arr) {
            deadline = Math.max(deadline, job.deadline);
        }

        int[] jobtime = new int[deadline + 1];
        Arrays.fill(jobtime, -1);
        int profit = 0;
        int jobnum = 0;

        for (Job job : arr) {
            for (int i = job.deadline; i > 0; i--) {
                if (jobtime[i] == -1) {
                    jobtime[i] = job.id;
                    profit += job.profit;
                    jobnum++;
                    break;
                }
            }
        }

        return new int[]{jobnum, profit};
    }
}
