import java.util.ArrayList;
import java.util.Collections;

// https://practice.geeksforgeeks.org/problems/activity-selection-1587115620/1
public class ActivitySelection {
    static class Data {
        int start;
        int end;

        Data(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int activitySelection(int start[], int end[], int n) {
        ArrayList<Data> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Data(start[i], end[i]));
        }

        Collections.sort(arr, (o1, o2) -> {
            return o1.end - o2.end;
        });

        int prev = arr.get(0).end;
        int result = 1;

        for (int i = 1; i < n; i++) {
            if (arr.get(i).start > prev) {
                result++;
                prev = arr.get(i).end;
            }
        }

        return result;
    }
}
