package Medium.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (arrayone, arraytwo) -> Integer.compare(arrayone[0], arraytwo[0]));
        List<int[]> finalresult = new ArrayList<>();

        // If we add an array to an ArrayList
        // On changing the array it will change in the ArrayList too
        // A reference is stored in the ArrayList

        int[] currinterval = intervals[0];
        finalresult.add(currinterval);
        // If we change currinterval, it will change in the ArrayList too

        for(int a = 1; a < intervals.length; a++){
            if (intervals[a][0] <= currinterval[1]){
                currinterval[1] = Math.max(currinterval[1], intervals[a][1]);
            } else {
                currinterval = intervals[a];
                finalresult.add(currinterval);
            }
        }
        return finalresult.toArray(new int[finalresult.size()][]);
    }
}
