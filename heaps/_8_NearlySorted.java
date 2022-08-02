package heaps;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/nearly-sorted-algorithm/0
public class _8_NearlySorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases > 0) {
            int size = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[size];

            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            Queue<Integer> pq = new PriorityQueue<>();
            int j;

            for (j = 0; j < size; j++) {
                if (j >= k) {
                    arr[j - k] = pq.poll();
                }
                pq.offer(arr[j]);
            }

            while (!pq.isEmpty()) {
                arr[j - k] = pq.poll();
                j++;
            }

            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();

            testcases--;
        }
        sc.close();
    }
}
