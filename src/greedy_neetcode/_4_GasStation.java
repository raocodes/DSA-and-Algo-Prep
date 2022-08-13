package greedy_neetcode;

// https://leetcode.com/problems/gas-station/
public class _4_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int costsum = 0;
        for (int num : cost) {
            costsum += num;
        }
        int gassum = 0;
        for (int num : gas) {
            gassum += num;
        }

        if (costsum > gassum) {
            return -1;
        }

        // We know that now, a solution surely exists
        // We just find the point from where the value always remains positive till the
        // end
        // This is because if it is positive till the end
        // Since answer exists it will the correct start

        int total = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];

            if (total < 0) {
                total = 0;
                start = i + 1;
            }
        }

        return start;
    }
}
