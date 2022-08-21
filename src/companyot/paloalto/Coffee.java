package companyot.paloalto;

import java.util.Arrays;
import java.util.Scanner;

class Coffee {
//    static int[][] dp;
    public static int find(int[] available, int coffeeNeeded) {
        int[][] dp = new int[available.length + 1][coffeeNeeded + 1];

        for (int i = 0; i < available.length + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < coffeeNeeded + 1; i++) {
            dp[0][i] = 100000000;
        }

        for (int i = 1; i < available.length + 1; i++) {
            for (int j = 1; j < coffeeNeeded + 1; j++) {
                if (available[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - available[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[available.length][coffeeNeeded];
    }


//    public static int findMemoized(int[] available, int index, int coffeeNeeded) {
//        if (coffeeNeeded == 0) {
//            return 0;
//        }
//
//        if (index < 0) {
//            return 100000000;
//        }
//
//        if (dp[index][coffeeNeeded] != -1) {
//            return dp[index][coffeeNeeded];
//        }
//
//        if (available[index] <= coffeeNeeded) {
//            return dp[index][coffeeNeeded] = Math.min(1 + find(available, index, coffeeNeeded - available[index]),
//                    find(available, index - 1, coffeeNeeded));
//        } else {
//            return dp[index][coffeeNeeded] = find(available, index - 1, coffeeNeeded);
//        }
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        while (testcases > 0) {
            int coffeeNeeded = in.nextInt();
            int size = in.nextInt();
            int[] available = new int[size];

            for (int i = 0; i < size; i++) {
                available[i] = in.nextInt();
            }

            Arrays.sort(available);

//            dp = new int[available.length][coffeeNeeded + 1];
//            for (int[] row : dp) {
//                Arrays.fill(row, -1);
//            }

            int result = find(available, coffeeNeeded);
            if (result >= 100000000) {
                System.out.println("NO");
            } else {
                System.out.println(result);
            }
            testcases--;
        }
        in.close();
    }
}
