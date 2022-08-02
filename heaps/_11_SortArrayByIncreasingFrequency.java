package heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/sort-array-by-increasing-frequency/
public class _11_SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        Queue<QueueData> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.freq == o2.freq) {
                return o2.val - o1.val;
            }
            return o1.freq - o2.freq;
        });
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new QueueData(entry.getValue(), entry.getKey()));
        }

        int count = 0;
        while (!pq.isEmpty()) {
            QueueData temp = pq.poll();
            int countin = 0;
            while (countin < temp.freq) {
                nums[count++] = temp.val;
                countin++;
            }
        }

        return nums;
    }
}

class QueueData {
    int freq;
    int val;

    QueueData(int freq, int val) {
        this.freq = freq;
        this.val = val;
    }
}
