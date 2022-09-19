package companyot.mckinsey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;

public class GroupFriends {
    public static List<Integer> getTheGroups(int n, List<String> queryType, List<Integer> students1,
            List<Integer> students2) {
        List<Integer> result = new ArrayList<>();

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < queryType.size(); i++) {
            int s1 = students1.get(i);
            int s2 = students2.get(i);
            if (queryType.get(i).equals("Friend")) {
                if (map.containsKey(s1) && map.containsKey(s2)) {
                    HashSet<Integer> temp = new HashSet<>();
                    temp.addAll(map.get(s1));
                    temp.addAll(map.get(s2));
                    map.put(s1, temp);
                    map.put(s2, temp);
                } else if (map.containsKey(s1) && !map.containsKey(s2)) {
                    map.put(s2, map.get(s1));
                    map.get(s1).add(s2);
                } else if (!map.containsKey(s1) && map.containsKey(s2)) {
                    map.put(s1, map.get(s2));
                    map.get(s2).add(s1);
                } else if (!map.containsKey(s1) && !map.containsKey(s2)) {
                    HashSet<Integer> temp = new HashSet<>();
                    temp.add(s1);
                    temp.add(s2);
                    map.put(s1, temp);
                    map.put(s2, temp);
                }
            } else {
                int left = map.containsKey(s1) ? map.get(s1).size() : 1;
                int right = map.containsKey(s2) ? map.get(s2).size() : 1;

                result.add(left + right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 2;

        String[] tempstr = new String[] { "Total" , "Total"};
        List<String> queryType = new ArrayList<>(Arrays.asList(tempstr));

        Integer[] temp;

        temp = new Integer[] { 1, 2 };
        List<Integer> students1 = new ArrayList<>(Arrays.asList(temp));
        temp = new Integer[] { 2, 1 };
        List<Integer> students2 = new ArrayList<>(Arrays.asList(temp));

        System.out.println(getTheGroups(n, queryType, students1, students2));
    }
}
