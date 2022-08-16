package dp_neetcode1D;

// https://leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        
        // We maintain a currmin and a currmax due to negative numbers
        // Sometimes the min from before multiplied by negative number gives us the max
        
        int currmin = 1;
        int currmax = 1;
        
        for(int num : nums){
            if(num == 0){
                // We reset the values
                // Basically we are just ignoring the values
                currmin = 1;
                currmax = 1;
            }
            
            int temp = currmax;
            currmax = Math.max(num * currmax, num * currmin);
            currmax = Math.max(currmax, num); // We have to also compare with the number itself
            currmin = Math.min(num * temp, num * currmin);
            currmin = Math.min(currmin, num);

            result = Math.max(result, currmax);
        }
        
        return result;
    }
}
