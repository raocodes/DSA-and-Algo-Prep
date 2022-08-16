package recursionandbacktracking_striver;

import java.util.ArrayList;

// https://www.codingninjas.com/codestudio/problems/983635?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
public class _6_WordBreak {
    public static void findSentences(int index, String s, ArrayList<String> dictionary, ArrayList<String> sentence,
                                     ArrayList<String> result) {
        if (index == s.length()) {
            // Reached the end
            result.add(String.join(" ", sentence));
            return;
        }

        for (int end = index; end < s.length(); end++) {
            // end = index because we also consider single characters as a possible
            // substring
            if (dictionary.contains(s.substring(index, end + 1))) {
                sentence.add(s.substring(index, end + 1));
                findSentences(end + 1, s, dictionary, sentence, result);
                sentence.remove(sentence.size() - 1);
            }
        }
    }

    public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
        ArrayList<String> sentence = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        findSentences(0, s, dictionary, sentence, result);

        return result;
    }
}
