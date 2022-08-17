package paloalto;

import java.util.*;

class solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        while (testcases > 0) {
            int size = in.nextInt();
            int[] binary = new int[size];
            String input = in.next();
            for (int i = 0; i < size; i++) {
                binary[i] = Character.getNumericValue(input.charAt(i));
            }
            ArrayList<Integer> temp = new ArrayList<>();
            for (int num : binary) {
                temp.add(num);
            }
            Collections.sort(temp);
            int count = 0;
            for (int i = 0; i < temp.size(); i++) {
                if (binary[i] != temp.get(i) && binary[i] == 0) {
                    count++;
                }
            }
            int newcount = 0;
            Collections.reverse(temp);
            for (int i = 0; i < temp.size(); i++) {
                if (binary[i] != temp.get(i) && binary[i] == 0) {
                    newcount++;
                }
            }
            System.out.println(Math.min(count, newcount));
            testcases--;
        }
        in.close();
    }
}