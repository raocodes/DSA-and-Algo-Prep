package Others.Leetcode_250_Sheet.Easy.Arrays;

public class _4_MoveZeros {
    public void moveZeroes(int[] nums) {
        int curr = 0;
        for(int a = 0; a < nums.length; a++){
            if (nums[a] != 0){
                nums[curr++] = nums[a];
            }
        }
        for(;curr < nums.length; curr++){
            nums[curr] = 0;
        }
    }
}
