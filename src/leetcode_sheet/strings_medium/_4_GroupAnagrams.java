package leetcode_sheet.strings_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/group-anagrams/
public class _4_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        int[] count;

        for (String str : strs) {
            count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 97]++;
            }

            List<String> list = map.get(Arrays.toString(count));
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(str);

            map.put(Arrays.toString(count), list);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> anagram : map.values()) {
            result.add(anagram);
        }

        return result;
    }
}
