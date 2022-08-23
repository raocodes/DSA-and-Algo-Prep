// https://leetcode.com/problems/count-number-of-nice-subarrays/
public class CountNumberOfNiceSubarrays {
    private boolean isOdd(int num) {
        if (num % 2 != 0) {
            return true;
        }
        return false;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int odd = 0;
        int result = 0;
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (isOdd(nums[right])) {
                odd++;

                if (odd == k) {
                    count = 1; // We have at minimum one subarray
                    while (!isOdd(nums[left++])) {
                        count++;
                    }
                    // We can form more subarrays by removing non-odd numbers from the left
                    result += count;

                    odd--; // We removed the left most odd number
                }
            } else {
                // If we encounter more even numbers we can have count subarrays again
                // By adding this element we can again consider the left ones
                // So we do count * number of even numbers after meeting k
                // We do this till we reach another odd
                result += count;
            }
        }

        return result;
    }
}
