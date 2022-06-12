package others.leetcode_sheet.easy.strings;

public class _1_AddStrings {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0, temp1, temp2, temp3;
        StringBuilder sum = new StringBuilder();
        while (index1 >= 0 || index2 >= 0 || carry != 0) {
            temp1 = index1 < 0 ? 0 : Character.getNumericValue(num1.charAt(index1--));
            temp2 = index2 < 0 ? 0 : Character.getNumericValue(num2.charAt(index2--));
            temp3 = temp1 + temp2 + carry;
            carry = temp3 / 10 != 0 ? 1 : 0;
            temp3 = temp3 % 10;
            sum.insert(0, String.valueOf(temp3));
        }
        return (sum.toString());
    }
}
