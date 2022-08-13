package slidingwindow_av;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/fruit-into-baskets/
public class _10_FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int max = 0;
        int left = 0;
        
        for(int right = 0; right < fruits.length; right++){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            
            if(map.size() <= 2){
                max = Math.max(max, right - left + 1);
            }
            
            while(map.size() > 2){
                int curr = map.get(fruits[left]);
                if(curr == 1){
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], curr - 1);
                }
                left++;
            }
        }
        
        return max;
    }
}
