package neetcode_150.arrays_and_hashing;

public class _2_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] characterHist = new int[26];

        for (int index = 0; index < s.length(); index++) {
            characterHist[s.charAt(index) - 'a']++;
            characterHist[t.charAt(index) - 'a']--;
        }

        for (int hist : characterHist) {
            if (hist != 0) {
                return false;
            }
        }

        return true;
    }
}
