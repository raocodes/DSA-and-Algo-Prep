package companyot.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Memory {
    public static int minimizeMemory(List<Integer> processes, int m){
        int totalsum = 0;
        int windowsum = 0;
        int left = 0;

        for(int process : processes){
            totalsum += process;
        }

        int min = totalsum;

        for(int right = 0; right < processes.size(); right++){
            windowsum += processes.get(right);
            if(right - left + 1 == m){
                min = Math.min(min, totalsum - windowsum);
                windowsum -= processes.get(left);
                left++;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4, 6, 10, 8, 2, 1};
        List<Integer> procesess = new ArrayList<>(Arrays.asList(arr));
        System.out.println(minimizeMemory(procesess, 3));
    }
}
