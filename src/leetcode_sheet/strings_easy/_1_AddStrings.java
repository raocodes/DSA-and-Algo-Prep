package leetcode_sheet.strings_easy;

// https://leetcode.com/problems/add-strings/
public class _1_AddStrings {
    public String addStrings(String num1, String num2) {
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();

        while (idx1 >= 0 || idx2 >= 0 || carry != 0) {
            int op1, op2;
            op1 = idx1 < 0 ? 0 : Character.getNumericValue(num1.charAt(idx1));
            op2 = idx2 < 0 ? 0 : Character.getNumericValue(num2.charAt(idx2));

            int sum = op1 + op2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            res.append(sum);
            if (idx1 >= 0) idx1--;
            if (idx2 >= 0) idx2--;
        }

        return res.reverse().toString();
    }
}
