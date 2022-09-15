package companyot.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Parcel {
    public static long getMinimumCost(List<Integer> parcels, int k) {
        int countInTruck = parcels.size();
        if (countInTruck == k) {
            return 0;
        }

        HashSet<Integer> alreadyInTruck = new HashSet<>(parcels);

        long total = 0;
        int curr = 1;

        while (countInTruck < k) {
            if (!alreadyInTruck.contains(curr)) {
                total += curr;
                countInTruck++;
            }
            curr++;
        }

        return total;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 2, 3, 6, 10, 11 };
        List<Integer> parcels = new ArrayList<>(Arrays.asList(arr));
        System.out.println(getMinimumCost(parcels, 9));
    }
}
