import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// https://leetcode.com/problems/frog-jump/
public class FrogJump {
    Map<String, Boolean> dp;

    public boolean solve(int currstep, int prev, int end, HashSet<Integer> stones) {
        if (currstep == end) {
            return true;
        }

        String key = currstep + "-" + prev;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (stones.contains(currstep + prev)) {
            if (solve(currstep + prev, prev, end, stones)) {
                dp.put(key, true);
                return true;
            }
        }

        if (stones.contains(currstep + prev + 1)) {
            if (solve(currstep + prev + 1, prev + 1, end, stones)) {
                dp.put(key, true);
                return true;
            }
        }

        if (prev > 1 && stones.contains(currstep + prev - 1)) {
            if (solve(currstep + prev - 1, prev - 1, end, stones)) {
                dp.put(key, true);
                return true;
            }
        }

        dp.put(key, false);
        return false;
    }

    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }

        dp = new HashMap<>();
        HashSet<Integer> stoneslist = new HashSet<>();
        for (int stone : stones) {
            stoneslist.add(stone);
        }

        return solve(1, 1, stones[stones.length - 1], stoneslist);
    }
}
