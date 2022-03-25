package Easy.Strings;

public class _2_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        java.util.Arrays.sort(strs);
        // We need to only compare the last and first string after sorting
        String strone = strs[0];
        String strtwo = strs[strs.length - 1];

        StringBuilder res = new StringBuilder();
        for (int a = 0; a < strone.length(); a++) {
            if (strone.charAt(a) == strtwo.charAt(a))
                res.append(strone.charAt(a));
            else
                return res.toString();
        }
        return res.toString();
    }
}

class testlongest {
    public static void main(String[] args) {
        _2_LongestCommonPrefix obj = new _2_LongestCommonPrefix();
        System.out.println(obj.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
    }
}
