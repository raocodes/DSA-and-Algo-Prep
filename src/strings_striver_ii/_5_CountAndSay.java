package strings_striver_ii;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/count-and-say/
public class _5_CountAndSay {
    public void recurSay(int index, List<Integer> result) {
        if (index == 1) {
            result.add(1);
            return;
        }

        recurSay(index - 1, result);
        int curr = result.get(0);
        int count = 0;
        int n = result.size();
        for (int i = 0; i < n; i++) {
            int temp = result.get(0);
            result.remove(0);
            if (temp == curr) {
                count++;
            } else {
                result.add(count);
                result.add(curr);
                curr = temp;
                count = 1;
            }
        }
        result.add(count);
        result.add(curr);
    }


    public String countAndSay(int n) {
        List<Integer> result = new ArrayList<>();
        recurSay(n, result);

        StringBuilder str = new StringBuilder();
        for (int num : result) {
            str.append(num);
        }

        return str.toString();
    }
}
