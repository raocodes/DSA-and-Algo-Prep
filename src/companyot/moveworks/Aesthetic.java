package  companyot.moveworks;

import java.util.*;

public class Aesthetic {
    public int solution(int[] A) {
        // Check if the tree is already aesthetically pleasing
        boolean flag = false;

        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] > A[i + 1] && A[i + 1] < A[i + 2]) {
                flag = true;
            } else if (A[i] < A[i + 1] && A[i + 1] > A[i + 2]) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }

        if (flag == true) {
            return 0;
        }

        List<Integer> arrlist = new ArrayList<>();
        for (int elem : A) {
            arrlist.add(elem);
        }

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            // Testing all possibilites
            List<Integer> temp = new ArrayList<>(arrlist);
            temp.remove(i);
            boolean isAesthetic = false;
            int j = 0;
            while (j < A.length - 3) {
                // We check 3 at a time
                if (!isAesthetic && j != 0) {
                    break;
                }

                if (temp.get(j) < temp.get(j + 1) && temp.get(j + 1) > temp.get(j + 2)) {
                    isAesthetic = true;
                } else if (temp.get(j) > temp.get(j + 1) && temp.get(j + 1) < temp.get(j + 2)) {
                    isAesthetic = true;
                } else {
                    isAesthetic = false;
                }
                j++;
            }

            if (isAesthetic) {
                // Was aesthetic after deleting
                count++;
            }
        }

        return count == 0 ? -1 : count;
    }
}
