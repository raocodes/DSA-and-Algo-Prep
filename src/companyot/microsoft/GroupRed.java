package companyot.microsoft;

import java.util.ArrayList;

public class GroupRed {
    public int solution(String S) {
        ArrayList<Integer> tracker = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'R') {
                tracker.add(i);
            }
        }

        if (tracker.size() == S.length()) {
            // There are only red
            return 0;
        }

        if (tracker.size() == 0) {
            // There are no red
            return 0;
        }

        int count = 0;
        int start = 0;
        int end = tracker.size() - 1;

        while (start < end) {
            count += tracker.get(end) - tracker.get(start) - end + start;
            start++;
            end--;
            if (count > 1000000000) {
                return -1;
            }
        }

        return count;
    }
}
