package Easy.Arrays;

public class _3_PlusOne {
    public int[] plusOne(int[] digits) {
        // 199
        // 109
        int index = digits.length - 1;
        int carry = 0;
        while (index >= 0) {
            if (digits[index] == 9) {
                carry = 1;
                digits[index] = 0;
                index--;
            } else {
                digits[index]++;
                carry = 0;
                break;
            }
        }
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            index = 1;
            result[0] = 1;
            for (int a = 0; a < digits.length; a++) {
                result[a + 1] = digits[a];
            }
            return result;
        }
        return digits;
    }
}
