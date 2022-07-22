package slidingwindow_av;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
public class _3_CountOccurencesOfAnagrams {
    int search(String pat, String txt) {
        int windowsize = pat.length();

        int[] tarr = new int[26];
        int[] parr = new int[26];

        int count = 0;

        for (int i = 0; i < windowsize; i++) {
            tarr[txt.charAt(i) - 97]++;
            parr[pat.charAt(i) - 97]++;
        }

        if (Arrays.equals(tarr, parr)) {
            count++;
        }

        int start = 0;
        int end = windowsize;
        while (end < txt.length()) {
            tarr[txt.charAt(start) - 97]--;
            tarr[txt.charAt(end) - 97]++;
            start++;
            end++;

            if (Arrays.equals(tarr, parr)) {
                count++;
            }
        }

        return count;
    }
}
