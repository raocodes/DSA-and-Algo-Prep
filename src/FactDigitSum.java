import java.util.ArrayList;
import java.util.Collections;

// https://practice.geeksforgeeks.org/problems/fact-digit-sum4125/1
public class FactDigitSum {
    ArrayList<Integer> FactDigit(int N) {
        int[] fact = new int[10];
        fact[0] = 1;
        for (int i = 1; i < 10; i++) {
            fact[i] = fact[i - 1] * i;
        }

        ArrayList<Integer> result = new ArrayList<>();
        int i = 9;
        while (i > 0 && N != 0) {
            if (fact[i] <= N) {
                N -= fact[i];
                result.add(i);
            } else {
                i--;
            }
        }

        Collections.reverse(result);
        return result;
    }
}
