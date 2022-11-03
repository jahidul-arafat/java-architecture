package org.datascience.datamanipulation;


import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;


public class PlayGround {
    public static void main(String[] args) {
        Map<String, Long> xMap = new HashMap<>();
        xMap.put("A",10l);
        xMap.put("B",11l);
        xMap.put("C",10l);
        xMap.put("D",11l);
        xMap.put("E",12l);

        System.out.println(xMap);
//        var swappedMap = xMap
//                .entrySet()
//                .stream()
//                .collect(Collectors.toMap(
//                        Map.Entry::getValue,
//                        Map.Entry::getKey
//                ));
//        System.out.println(swappedMap);

        BiFunction<Long, Map<String,Long>,String> xFunc = (itemCount, tmpXMap)-> {
            var keyOftheValue=tmpXMap
                    .entrySet()
                    .stream()
                    .filter(entry -> itemCount.equals(entry.getValue()))
                    .map(entry -> entry.getKey())
                    .collect(Collectors.toList())
                    .stream().findFirst()
                    .orElse(null);
            return keyOftheValue;
        };
        // get unique set of all itemPurchaseCount made by Members
        var uniqueItemCountSet = xMap.values().stream().collect(Collectors.toList());

        Map<Long, List<String>> yMap = new HashMap<>();
        Map<String,Long> copyxMap = new HashMap<>();
        copyxMap.putAll(xMap);

        for (Long itemCount: uniqueItemCountSet
        ) {
            if (!yMap.keySet().contains(itemCount))
                yMap.put(itemCount,new ArrayList<>());
            var theKey = xFunc.apply(itemCount,copyxMap);
            yMap.get(itemCount).add(theKey);
            copyxMap.remove(theKey);
        }

        System.out.println("yMap: "+yMap);
        System.out.println("copy: "+ copyxMap);
        System.out.println("original:" + xMap);

        var x= yMap
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry)-> entry.getKey(),
                        (entry)-> entry.getValue()
                                .stream()
                                .collect(Collectors.counting())
                ));
        System.out.println(x);
        var output= x.values()
                .stream()
                .reduce(0l,(acc,z)-> acc+z);
        System.out.println(output);

    }






}
