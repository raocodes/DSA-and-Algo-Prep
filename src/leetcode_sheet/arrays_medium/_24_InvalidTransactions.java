package leetcode_sheet.arrays_medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/invalid-transactions/
public class _24_InvalidTransactions {
    class Transaction {
        int index;
        String name;
        int time;
        int amount;
        String city;

        Transaction(String data, int index) {
            this.index = index;
            String[] splitup = data.split(",");
            name = splitup[0];
            time = Integer.parseInt(splitup[1]);
            amount = Integer.parseInt(splitup[2]);
            city = splitup[3];
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Transaction>> map = new HashMap<>();

        for (int i = 0; i < transactions.length; i++) {
            Transaction trns = new Transaction(transactions[i], i);

            if (!map.containsKey(trns.name)) {
                map.put(trns.name, new ArrayList<>());
            }
            map.get(trns.name).add(trns);
        }

        List<String> result = new ArrayList<>();

        for (List<Transaction> list : map.values()) {
            for (Transaction trns : list) {
                if (trns.amount > 1000) {
                    result.add(transactions[trns.index]);
                } else {
                    int currtime = trns.time;
                    for (Transaction othertrns : list) {
                        if (othertrns == trns) {
                            continue;
                        }
                        if (Math.abs(othertrns.time - currtime) <= 60 && !othertrns.city.equals(trns.city)) {
                            result.add(transactions[trns.index]);
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }
}
