package com.example.java;

import java.util.*;

public class DataCollectionDemo {
    // Class variable


    public static void main(String[] args) {
        Map<String, String> stateCapMap = new HashMap<>();
        stateCapMap.put("stateA", "capitalA");
        stateCapMap.put("stateB", "capitalB");
        stateCapMap.put("stateC", "capitalC");

        System.out.println(stateCapMap);

        stateCapMap.put("stateD", "capitalD");
        System.out.println(stateCapMap);

        String cap = stateCapMap.get("stateB");
        System.out.println("Capital of stateB is: " + cap);

        stateCapMap.remove("stateB");
        System.out.println("Map<After removing>: " + stateCapMap);

        Iterator<String> myIterator = stateCapMap.keySet().iterator();
        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }

        for (String item : stateCapMap.values()
        ) {
            System.out.println(item);

        }

        System.out.println("");
        stateCapMap.keySet().forEach(System.out::println);

        System.out.println(stateCapMap);

        System.out.println("");
        Set<String> keySet = stateCapMap.keySet();
        Iterator<String> iterator1 = keySet.iterator();
        while (iterator1.hasNext()) {
            String state = iterator1.next();
            System.out.println(state + "->" + stateCapMap.get(state));
        }

        System.out.println("");
        for (String key : keySet
        ) {
            System.out.println(key + "->" + stateCapMap.get(key));

        }


    }
}
