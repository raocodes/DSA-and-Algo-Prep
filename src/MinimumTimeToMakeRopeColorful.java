// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
public class MinimumTimeToMakeRopeColorful {
    public int minCost(String colors, int[] neededTime) {
        int result = 0;

        for (int i = 0; i < colors.length() - 1; i++) {
            if (colors.charAt(i) == colors.charAt(i + 1)) {
                result += Math.min(neededTime[i], neededTime[i + 1]);
                neededTime[i + 1] = Math.max(neededTime[i], neededTime[i + 1]);
            }
        }

        return result;
    }
}
