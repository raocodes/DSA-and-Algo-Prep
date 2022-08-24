import java.util.ArrayList;
import java.util.Collections;

// https://practice.geeksforgeeks.org/problems/maximum-meetings-in-one-room/1
public class MaximumMeetingsinOneRoom {
    static class Data {
        int start;
        int end;
        int index;

        Data(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        ArrayList<Data> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr.add(new Data(S[i], F[i], i + 1));
        }

        Collections.sort(arr, (o1, o2) -> {
            return o1.end - o2.end;
        });

        // for(Data data : arr){
        // System.out.println(data.start + " " + data.end);
        // }

        int prev = -1;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            Data curr = arr.get(i);
            if (curr.start > prev) {
                result.add(curr.index);
                prev = curr.end;
            }
        }

        Collections.sort(result);

        return result;
    }
}
