package neetcode.dp_2d;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/interleaving-string/
public class InterleavingString {
    Map<String, Boolean> dp;

    public boolean find(int index1, int index2, int index3, String s1, String s2, String s3) {
        // If all elements in s1 and s2 are used and s3 is finished
        if (index1 == 0 && index2 == 0 && index3 == 0) {
            return true;
        }

        String key = index1 + "-" + index2 + "-" + index3;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        // If character is with both s1 and s2
        if (index1 - 1 >= 0 && index2 - 1 >= 0 && index3 - 1 >= 0 && s1.charAt(index1 - 1) == s2.charAt(index2 - 1)
                && s2.charAt(index2 - 1) == s3.charAt(index3 - 1)) {
            boolean result = find(index1 - 1, index2, index3 - 1, s1, s2, s3)
                    || find(index1, index2 - 1, index3 - 1, s1, s2, s3);
            dp.put(key, result);
            return result;
        }

        // If character is only with s1
        if (index1 - 1 >= 0 && index3 - 1 >= 0 && s1.charAt(index1 - 1) == s3.charAt(index3 - 1)) {
            boolean result = find(index1 - 1, index2, index3 - 1, s1, s2, s3);
            dp.put(key, result);
            return result;
        }

        // If character is only with s2
        if (index2 - 1 >= 0 && index3 - 1 >= 0 && s2.charAt(index2 - 1) == s3.charAt(index3 - 1)) {
            boolean result = find(index1, index2 - 1, index3 - 1, s1, s2, s3);
            dp.put(key, result);
            return result;
        }

        dp.put(key, false);
        return false;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new HashMap<>();
        return find(s1.length(), s2.length(), s3.length(), s1, s2, s3);
    }
}
