package heaps_av_neetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/design-twitter/
public class _6_DesignTwitter {
    final Map<Integer, Queue<Post>> postlist;
    final Map<Integer, HashSet<Integer>> followlist;
    int time;

    public _6_DesignTwitter() {
        postlist = new HashMap<>();
        followlist = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        Queue<Post> queue = postlist.getOrDefault(userId, new LinkedList<>());
        queue.offer(new Post(time, tweetId));
        postlist.put(userId, queue);
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        Queue<Post> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.time < o2.time) {
                return 1;
            } else if (o1.time > o2.time) {
                return -1;
            } else {
                return 0;
            }
        });

        if (postlist.containsKey(userId)) {
            for (Post post : postlist.get(userId)) {
                pq.offer(post);
            }
        }

        if (followlist.containsKey(userId)) {
            for (int followeeId : followlist.get(userId)) {
                if (postlist.containsKey(followeeId)) {
                    for (Post post : postlist.get(followeeId)) {
                        pq.offer(post);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (count < 10 && !pq.isEmpty()) {
            result.add(pq.poll().postid);
            count++;
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        HashSet<Integer> hash = followlist.getOrDefault(followerId, new HashSet<>());
        hash.add(followeeId);
        followlist.put(followerId, hash);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followlist.containsKey(followerId)) {
            followlist.get(followerId).remove(followeeId);
        }
    }
}

class Post {
    int time;
    int postid;

    Post(int time, int postid) {
        this.time = time;
        this.postid = postid;
    }
}
