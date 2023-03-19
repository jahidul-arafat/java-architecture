package org.jarotball.collections.project_9_maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BasicApp {
    public static void main(String[] args) {
        // HashMap vs LinkedHashMap
        // HashMap - dosen't guarantee ordering O(1)
        // LinkedHashSet - guarantee Ordering O(1)
        Map<String,Integer> strIntMap = new LinkedHashMap<>();
        strIntMap.put("One",1);
        strIntMap.put("Two",2);
        strIntMap.put("1",3);
        strIntMap.put("A",4);
        strIntMap.put("Four",5);
        strIntMap.putIfAbsent("Five",10);

        var keys = strIntMap.keySet();
        System.out.println(keys);

        strIntMap.keySet()
                .forEach(key -> System.out.format("%s: %s >> %s%n",key,strIntMap.get(key),key.hashCode()));
        System.out.println(strIntMap.hashCode());



    }
}
