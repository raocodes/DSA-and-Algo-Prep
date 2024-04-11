package neetcode_150.arrays_and_hashing;

public class _1_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();

        for (int num : nums) {
            if (visited.contains(num)) {
                return true;
            }
            visited.add(num);
        }

        return false;
    }
}
