// https://leetcode.com/problems/expressive-words/
public class ExpressiveWords {
    public boolean check(String str, String word) {
        int strlen = str.length();
        int wrdlen = word.length();
        int i = 0;
        int j = 0;
        int counti = 0;
        int countj = 0;

        while (i < strlen && j < wrdlen) {
            if (str.charAt(i) != word.charAt(j)) {
                // If the starting character does not
                return false;
            }

            while (counti < strlen && str.charAt(counti) == str.charAt(i)) {
                // Counting the number of same letters in str
                counti++;
            }

            while (countj < wrdlen && word.charAt(countj) == word.charAt(j)) {
                // Counting the number of same letters in word
                countj++;
            }

            int strcount = counti - i;
            int wrdcount = countj - j;

            if (strcount < wrdcount || (strcount != wrdcount && strcount < 3)) {
                // If string has a smaller count or strcount has a count lesser than 3
                return false;
            }

            i = counti;
            j = countj;
        }

        return i == strlen && j == wrdlen;
    }

    public int expressiveWords(String s, String[] words) {
        int count = 0;

        for (String wrd : words) {
            if (check(s, wrd)) {
                count++;
            }
        }

        return count;
    }
}
