package companyot.goldman;

import java.util.Arrays;

public class ThreeStringAnagram {
    static String checkAnagram(String s1, String s2, String s3) {
        if (!(s1.length() == s2.length() && s2.length() == s3.length())) {
            return "NO";
        }

        int[] hashone = new int[26];
        int[] hashtwo = new int[26];

        // String s1
        for (int i = 0; i < s1.length(); i++) {
            hashone[s1.charAt(i) - 'a']++;
        }

        // String s2
        for (int i = 0; i < s2.length(); i++) {
            hashtwo[s2.charAt(i) - 'a']++;
        }

        if (!Arrays.equals(hashone, hashtwo)) {
            return "NO";
        }

        Arrays.fill(hashtwo, 0);

        // String s3
        for (int i = 0; i < s3.length(); i++) {
            hashtwo[s3.charAt(i) - 'a']++;
        }

        if (!Arrays.equals(hashone, hashtwo)) {
            return "NO";
        } else {
            return "YES";
        }
    }

    public static void main(String[] args) {
        System.out.println(checkAnagram("bbac", "abcb", "acbba"));
    }
}
