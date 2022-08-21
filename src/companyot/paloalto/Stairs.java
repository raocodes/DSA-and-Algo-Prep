package companyot.paloalto;

import java.util.Scanner;

class Stairs {
    public static void print(int[] arr, int size, int sum) {
        int end = sum + 1;

        for (int i = size - 1; i >= 0; i--) {
            for (int j = 1; j <= end; j++) {
                if (j < end - arr[i]) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }

            for (int k = 0; k < arr[i] - 1; k++) {
                System.out.println();
                for (int a = 1; a < end - arr[i]; a++) {
                    System.out.print("  ");
                }
                System.out.print("* ");
            }
            System.out.println();
            end = end - arr[i];
        }
        System.out.print("*");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        while (testcases > 0) {
            int size = in.nextInt();
            int[] arr = new int[size];

            for (int i = 0; i < size; i++) {
                arr[i] = in.nextInt();
            }

            int sum = 0;
            for (int elem : arr) {
                sum += elem;
            }

            print(arr, size, sum);
            testcases--;
        }
        in.close();
    }
}
