package org.codeclinic.utility;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyCounter {
    public static Map<String, Long> stringFrequencyCounter(List<String> strList){
        return strList
                .stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }

    public static Map<Integer, Long> intFrequencyCounter(List<Integer> integerList){
        return integerList
                .stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }

    public static Map<Double, Long> doubleFrequencyCounter(List<Double> doubleList){
        return doubleList
                .stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }

}
