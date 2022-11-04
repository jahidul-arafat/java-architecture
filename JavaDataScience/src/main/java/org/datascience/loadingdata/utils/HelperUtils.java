package org.datascience.loadingdata.utils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HelperUtils {
    public static Map<String, Long> countOccurancesString(List<String> list){
        var countOcc=list
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return countOcc;
    }
}
