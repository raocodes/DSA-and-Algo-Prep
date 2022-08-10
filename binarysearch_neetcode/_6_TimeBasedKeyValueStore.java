package binarysearch_neetcode;

import java.util.ArrayList;
import java.util.HashMap;

// https://leetcode.com/problems/time-based-key-value-store/
class MapData {
    String value;
    int timestamp;

    MapData(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

public class _6_TimeBasedKeyValueStore {
    HashMap<String, ArrayList<MapData>> map;

    public _6_TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<MapData>());
        }
        map.get(key).add(new MapData(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        ArrayList<MapData> data = map.get(key);
        int start = 0;
        int end = data.size() - 1;
        String res = "";

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (data.get(mid).timestamp == timestamp) {
                return data.get(mid).value;
            } else if (data.get(mid).timestamp < timestamp) {
                start = mid + 1;
                res = data.get(mid).value;
            } else {
                end = mid - 1;
            }
        }

        return res;
    }
}
