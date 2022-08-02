package heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class QueueData {
    int diff;
    int val;

    QueueData(int diff, int val) {
        this.diff = diff;
        this.val = val;
    }
}

public class _9_KClosedNumbers {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<QueueData> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.diff == o2.diff) {
                return o2.val - o1.val;
                // Diff is same so bigger val is treated as bigger
            } else {
                return o2.diff - o1.diff;
            }
        });

        for (int num : arr) {
            pq.offer(new QueueData(Math.abs(num - x), num));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().val);
        }
        Collections.sort(result);

        return result;
    }
}
