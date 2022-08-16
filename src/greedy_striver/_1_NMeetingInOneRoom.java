package greedy_striver;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
public class _1_NMeetingInOneRoom {
    public static int maxMeetings(int start[], int end[], int n) {
        Arrays.sort(start);
        Arrays.sort(end);

        int currstart = 1;
        int currend = 0;
        int currrooms = 1;
        int result = 1;

        while (currstart < n && currend < n) {

            if (start[currstart] < end[currend]) {
                currrooms++;
                currstart++;
            } else {
                currrooms--;
                currend++;
            }

            result = Math.max(result, currrooms);
        }

        return result;
    }
}
