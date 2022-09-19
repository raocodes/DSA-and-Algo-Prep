package companyot.mckinsey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsegmentSort {
    public static int findMaxSubsegmentsCount(List<Integer> arr) {
        int[] leftMax = new int[arr.size()];
        int[] rightMin = new int[arr.size()];

        leftMax[0] = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr.get(i));
        }

        rightMin[arr.size() - 1] = arr.get(arr.size() - 1);

        for (int i = arr.size() - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr.get(i));
        }

        int count = 0;

        for (int i = 0; i < arr.size() - 1; i++) {
            if (leftMax[i] <= rightMin[i + 1]) {
                count++;
            }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 2, 1, 3, 2, 4, 4, 5, 8, 7, 7 };
        List<Integer> arrlist = new ArrayList<>(Arrays.asList(arr));
        System.out.println(findMaxSubsegmentsCount(arrlist));
    }
}
