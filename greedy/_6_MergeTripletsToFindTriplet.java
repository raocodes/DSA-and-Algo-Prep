package greedy;

import java.util.ArrayList;

// https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
public class _6_MergeTripletsToFindTriplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        ArrayList<int[]> filtered = new ArrayList<>();

        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                filtered.add(triplet);
            }
        }

        for (int i = 0; i < target.length; i++) {
            boolean flag = false;
            for (int[] triplet : filtered) {
                if (triplet[i] == target[i]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }

        return true;
    }
}
