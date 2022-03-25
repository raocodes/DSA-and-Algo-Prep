package Medium.Arrays;

public class _3_ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        // We start of with filling up the output array with product of the elements to
        // the left of the element (excluding itself)
        // This is rather than having the product of elements on both sides excluding it

        int left = 1; // Elements to the left of the first entry does not exist (Therefore 1)
        for (int a = 0; a < nums.length; a++) {
            output[a] = left;
            // left *= output[a];
            left *= nums[a]; // Using nums instead of output since it has the values not output
        }

        // Now we repeat the same but follow from the right
        // When we iterate, the product of the elements to the right and what is in the
        // output array at position a is going to be the product of all the elements in
        // the array excluding value at a

        int right = 1;
        for (int a = nums.length - 1; a > -1; a--) {
            output[a] *= right;
            // right *= output[a];
            right *= nums[a]; // Using nums instead of output since it has the values not output
        }
        // Therefore the product of what is on the right and the left should give the
        // final answer
        return output;
    }
}
