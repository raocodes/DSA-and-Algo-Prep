package striver_sheet.strings_ii;

// https://leetcode.com/problems/valid-anagram/
public class _4_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // int[] hashs = new int[26];
        // int[] hasht = new int[26];

        // for(int i = 0; i < s.length(); i++){
        // hashs[s.charAt(i) - 97] += 1;
        // hasht[t.charAt(i) - 97] += 1;
        // }

        // for(int i = 0; i < 26; i++){
        // if(hashs[i] != hasht[i]){
        // return false;
        // }
        // }

        int[] hash = new int[26];

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] += 1;
            hash[t.charAt(i) - 'a'] -= 1;
        }

        for (int element : hash) {
            if (element != 0) {
                return false;
            }
        }

        return true;
    }
}
