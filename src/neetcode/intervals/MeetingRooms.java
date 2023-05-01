package neetcode.intervals;

import java.util.ArrayList;
import java.util.Collections;

// https://www.interviewbit.com/problems/meeting-rooms/
public class MeetingRooms {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();

        for (ArrayList<Integer> row : A) {
            start.add(row.get(0));
            end.add(row.get(1));
        }

        Collections.sort(start);
        Collections.sort(end);

        int endidx = 0;
        int startidx = 1;
        int currrooms = 1;
        int result = 1;

        while (startidx < A.size() && endidx < A.size()) {
            if (start.get(startidx) < end.get(endidx)) {
                currrooms++;
                startidx++;
            } else {
                currrooms--;
                endidx++;
            }
            result = Math.max(result, currrooms);
        }

        return result;
    }
}
