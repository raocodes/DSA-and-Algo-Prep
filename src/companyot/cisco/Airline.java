package companyot.cisco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Airline {
    static class Entry {
        int fine;
        int choice;

        Entry(int choice) {
            this.choice = choice;
            this.fine = 0;
        }
    }

    public static int find(List<Integer> InitialAsk) {
        Queue<Entry> q = new LinkedList<>();
        boolean[] seats = new boolean[InitialAsk.size() + 1];

        Arrays.fill(seats, false);

        for (int entry : InitialAsk) {
            q.offer(new Entry(entry));
        }

        int totalfine = 0;

        while (!q.isEmpty()) {
            Entry curr = q.poll();

            if (seats[curr.choice] == false) {
                seats[curr.choice] = true;
            } else {
                curr.choice++;
                curr.fine += 10;
                totalfine += curr.fine;
                q.offer(curr);
            }
        }

        return totalfine;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        List<Integer> InitialAsk = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            InitialAsk.add(in.nextInt());
        }

        in.close();

        System.out.println(find(InitialAsk));
    }
}
