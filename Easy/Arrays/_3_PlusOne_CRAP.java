package Easy.Arrays;

import java.util.List;
import java.util.ArrayList;

public class _3_PlusOne_CRAP {
    public int[] plusOne(int[] digits) {
        boolean flag = true;
        List<Integer> result = new ArrayList<Integer>();

        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        }
        for (int a = digits.length - 1; a >= 0; a--) {
            if (digits[a] == 9 && flag == true) {
                if (a == 0) {
                    result.add(0, 0);
                    result.add(0, 1);
                } else {
                    result.add(0, 0);
                }
            } else if (flag == true) {
                result.add(0, digits[a] + 1);
                flag = false;
            } else {
                result.add(0, digits[a]);
            }
        }

        int[] resultarray = new int[result.size()];
        for (int i = 0; i < resultarray.length; i++) {
            resultarray[i] = result.get(i).intValue();
        }
        return resultarray;
    }
}
