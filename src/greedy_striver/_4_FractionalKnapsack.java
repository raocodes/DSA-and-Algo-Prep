package greedy_striver;

import java.util.Arrays;

public class _4_FractionalKnapsack {
    class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, (o1, o2) -> {
            double o1prwt = Double.valueOf(o1.value).doubleValue() / Double.valueOf(o1.weight).doubleValue();
            double o2prwt = Double.valueOf(o2.value).doubleValue() / Double.valueOf(o2.weight).doubleValue();

            if (o2prwt > o1prwt) {
                return 1;
            } else if (o1prwt > o2prwt) {
                return -1;
            } else {
                return 0;
            }
        });

        int remaining = W;
        double result = 0;
        for (int i = 0; i < n; i++) {
            // System.out.println(arr[i].value + " " + arr[i].weight + " " + remaining);
            int allowed = Math.min(remaining, arr[i].weight);
            double prwt = Double.valueOf(arr[i].value).doubleValue() / Double.valueOf(arr[i].weight).doubleValue();
            result += prwt * allowed;
            remaining -= allowed;
        }

        return result;
    }
}
