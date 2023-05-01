package aditya_verma.dp._4_matrixchainmultiplication;

import java.util.HashMap;
import java.util.Map;

// https://www.interviewbit.com/problems/scramble-string/
public class _4_ScrambledString {
    public Map<String, Boolean> dp = new HashMap<>();

    public boolean checkScramble(String A, String B) {
        if (A.equals(B)) {
            // If the strings are equal
            // No need to check
            return true;
        }
        if (A.length() <= 1 || B.length() <= 1) {
            // If any string is empty or leaf
            return false;
        }

        String key = A + " " + B;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        for (int i = 1; i < A.length(); i++) {
            // Start at one for substring logic
            boolean yesswap = checkScramble(A.substring(0, i), B.substring(B.length() - i, B.length()))
                    && checkScramble(A.substring(i, A.length()), B.substring(0, B.length() - i));

            boolean noswap = checkScramble(A.substring(0, i), B.substring(0, i))
                    && checkScramble(A.substring(i, A.length()), B.substring(i, B.length()));

            if (yesswap || noswap) {
                dp.put(key, true);
                return true;
            }
        }
        dp.put(key, false);
        return false;
    }

    public int isScramble(final String A, final String B) {
        if (A.length() != B.length()) {
            // Their lengths are not equal
            return 0;
        }
        if (A.length() == 0 && B.length() == 0) {
            // They are both empty
            return 1;
        }
        if (checkScramble(A, B)) {
            return 1;
        } else {
            return 0;
        }
    }
}
