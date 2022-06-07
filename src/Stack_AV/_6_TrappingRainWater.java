package Stack_AV;

public class _6_TrappingRainWater {
    static long trappingWater(int arr[], int n) {
        // This implementation does not have stack

        int[] maxl = new int[arr.length];
        int[] maxr = new int[arr.length];
        long result = 0;

        maxl[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxl[i] = Math.max(maxl[i - 1], arr[i]);
        }

        maxr[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            maxr[i] = Math.max(maxr[i + 1], arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            // Adding the amount of water on top of each building
            result += Math.min(maxr[i], maxl[i]) - arr[i];
        }

        return result;
    }
}
