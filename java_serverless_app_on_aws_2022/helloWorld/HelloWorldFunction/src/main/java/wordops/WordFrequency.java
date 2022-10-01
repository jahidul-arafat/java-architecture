package wordops;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequency {

    // Write a program which count the frequency of each number
    public Map<String, Long> handler(List<String> wordList){
        var output = wordList
                .stream()
                .collect(Collectors.groupingBy((word)->word, Collectors.counting()));
        return output;
    }

}
