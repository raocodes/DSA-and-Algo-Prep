package companyot.noclue;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class FrequencySort {
    public static int[] freqSort(int[] listEle) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int element : listEle) {
            map.put(element, map.getOrDefault(element, 0) + 1);
            ans.add(element);
        }

        Collections.sort(ans, (a, b) -> {
            return map.get(a) == map.get(b) ? a - b : map.get(b) - map.get(a);
        });

        int[] result = new int[ans.size()];
        int i = 0;

        for (int element : ans) {
            result[i++] = element;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 8, 9, 10 };

        System.out.println("Before sorting: " + Arrays.toString(arr));

        arr = freqSort(arr);

        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
