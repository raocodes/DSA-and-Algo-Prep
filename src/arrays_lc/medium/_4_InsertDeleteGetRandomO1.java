package arrays_lc.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

// https://leetcode.com/problems/insert-delete-getrandom-o1/
public class _4_InsertDeleteGetRandomO1 {
    final HashMap<Integer, Integer> map;
    final List<Integer> data;
    final Random random;

    public _4_InsertDeleteGetRandomO1() {
        random = new Random();
        map = new HashMap<>();
        data = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        data.add(val);
        map.put(val, data.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        // Removing from the end of an ArrayList is O(1)
        int last = data.get(data.size() - 1);
        int loc = map.get(val);

        if (last != val) {
            data.set(loc, last);
            map.put(last, loc);
        }

        data.remove(data.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(data.size());
        return data.get(index);
    }
}
