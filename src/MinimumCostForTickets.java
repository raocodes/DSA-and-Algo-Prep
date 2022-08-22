import java.util.Arrays;

// https://leetcode.com/problems/minimum-cost-for-tickets/
public class MinimumCostForTickets {
    int[] dp;

    public int find(int index, int[] days, int[] costs) {
        if (index >= days.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int nextindex;
        int day1 = costs[0] + find(index + 1, days, costs);

        for (nextindex = index; nextindex < days.length && days[nextindex] <= days[index] + 6; nextindex++)
            ;
        int day7 = costs[1] + find(nextindex, days, costs);

        for (nextindex = index; nextindex < days.length && days[nextindex] <= days[index] + 29; nextindex++)
            ;
        int day30 = costs[2] + find(nextindex, days, costs);

        return dp[index] = Math.min(day1, Math.min(day7, day30));
    }

    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length];
        Arrays.fill(dp, -1);
        return find(0, days, costs);
    }
}
