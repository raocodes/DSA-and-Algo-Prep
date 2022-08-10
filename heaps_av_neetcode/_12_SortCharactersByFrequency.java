package heaps_av_neetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/sort-characters-by-frequency/
public class _12_SortCharactersByFrequency {
    class QueueData {
        int freq;
        char val;

        QueueData(int freq, char val) {
            this.freq = freq;
            this.val = val;
        }
    }

    public String frequencySort(String s) {
        Queue<QueueData> pq = new PriorityQueue<>((o1, o2) -> {
            return o2.freq - o1.freq;
        });
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new QueueData(entry.getValue(), entry.getKey()));
        }

        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            QueueData temp = pq.poll();
            int count = 0;
            while (count < temp.freq) {
                result.append(temp.val);
                count++;
            }
        }

        return result.toString();
    }
}
