package greedy;

import java.util.TreeMap;

// https://leetcode.com/problems/hand-of-straights/
public class _5_HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (!map.isEmpty()) {
            int current = map.firstKey();
            for (int i = current; i < current + groupSize; i++) {
                if (!map.containsKey(i)) {
                    return false;
                }
                if (map.get(i) == 1) {
                    map.remove(i);
                } else {
                    map.put(i, map.get(i) - 1);
                }
            }
        }

        return true;
    }
}
