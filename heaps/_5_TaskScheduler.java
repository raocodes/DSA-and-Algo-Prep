package heaps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/task-scheduler/
public class _5_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1 < o2)
                return 1;
            else if (o1 > o2)
                return -1;
            else
                return 0;
        });

        Queue<QueueData> q = new LinkedList<>();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry.getValue());
        }

        int currtime = 0;
        while ((!pq.isEmpty() || !q.isEmpty())) {
            if (pq.isEmpty()) {
                // When adding back from the queue our new time is the unlock time of the
                // process
                currtime = Math.max(q.peek().time, currtime);
                pq.offer(q.poll().val);
            }

            int val = pq.poll();
            val--;
            currtime++;

            if (val > 0) {
                q.offer(new QueueData(val, currtime + n));
            }

            if (!q.isEmpty() && currtime >= q.peek().time) {
                pq.offer(q.poll().val);
            }
        }

        return currtime;
    }
}

class QueueData {
    int val;
    int time;

    QueueData(int val, int time) {
        this.val = val;
        this.time = time;
    }
}
