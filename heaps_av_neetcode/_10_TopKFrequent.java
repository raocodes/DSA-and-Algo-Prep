package heaps_av_neetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/top-k-frequent-elements/
public class _10_TopKFrequent {
    class QueueData {
        int freq;
        int val;

        QueueData(int freq, int val) {
            this.freq = freq;
            this.val = val;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Queue<QueueData> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.freq - o2.freq;
        });
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new QueueData(entry.getValue(), entry.getKey()));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[pq.size()];
        int count = 0;
        while (!pq.isEmpty()) {
            result[count++] = pq.poll().val;
        }

        return result;
    }
}
