package others.leetcode_sheet.easy.strings;

public class _3_ValidPalindrome {
    public boolean isPalindrome(String s) {
        for (int beg = 0, last = s.length() - 1; beg < last; beg++, last--) {
            if (s.charAt(beg) != s.charAt(last)) {
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        StringBuilder tocheckone = new StringBuilder();
        StringBuilder tochecktwo = new StringBuilder();
        tocheckone.append(s);
        tochecktwo.append(s);
        for (int beg = 0, last = s.length() - 1; beg < last; beg++, last--) {
            if (s.charAt(beg) != s.charAt(last)) {
                return isPalindrome(tocheckone.deleteCharAt(beg).toString())
                        || isPalindrome(tochecktwo.deleteCharAt(last).toString());
            }
        }
        return true;
    }
}

class testvalid {
    public static void main(String[] args) {
        _3_ValidPalindrome obj = new _3_ValidPalindrome();
        System.out.println(obj.validPalindrome("aba"));
        System.out.println(obj.validPalindrome("abca"));
        System.out.println(obj.validPalindrome("abc"));
    }
}