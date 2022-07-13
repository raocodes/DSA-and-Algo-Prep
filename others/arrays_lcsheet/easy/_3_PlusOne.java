package others.arrays_lcsheet.easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/plus-one/
public class _3_PlusOne {
    public int[] plusOne(int[] digits) {
        // Could speed it up if used only integer arrays
        List<Integer> result = new ArrayList<>();
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry != 0) {
                int temp = digits[i] + carry;
                if (temp < 10) {
                    carry = 0;
                } else {
                    temp = temp % 10;
                }
                result.add(0, temp);
            } else {
                result.add(0, digits[i]);
            }
        }
        if (carry == 1) {
            result.add(0, 1);
        }

        int[] resultarr = new int[result.size()];
        for (int i = 0; i < resultarr.length; i++) {
            resultarr[i] = result.get(i);
        }
        return resultarr;
    }
}
