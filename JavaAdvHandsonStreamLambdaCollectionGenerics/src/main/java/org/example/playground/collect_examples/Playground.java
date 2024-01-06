package org.example.playground.collect_examples;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Playground {
    // Class variable isLengthThan5 for universal access to the list
    // Predicate Syntax
        /*
        Here, T-> Generic Type
        Predicate<T> predicate = (input) -> {
            // code to evaluate the predicate
            return booleanValue;
        }
         */
    static Predicate<String> isLengthThan5 = (word) -> word!=null && word.length() >= 5;
    static Predicate<String> isWordNotNull = (word) -> word!=null;

    /**
 * Returns a list of words from the given list of words that have a length greater than or equal to 5 characters.
 *
 * @param wrdList the list of words from which to retrieve the words with a length greater than or equal to 5 characters
 * @return a list of words from the given list of words that have a length greater than or equal to 5 characters
 */
protected static List<String> getWrdListGt5Length(@NotNull List<String> wrdList) {
    // get the list of all words where length >= 5 char
    List<String> wordsGt5CharLength = wrdList.stream()
            .filter(isLengthThan5)
            .collect(Collectors.toList());
    return wordsGt5CharLength;
}

    // method to get the unique list of words having length greater than 5
    //@NotNull // will improve the safety and reliability of the metho by ensuring that the null values are not passed to it and that it always returns a not-null value
    protected static Set<String> getUniqueWrdListGt5Length(@NotNull List<String> wrdList) {
        // predicate to filter the list of strings if the length is greater than 5
        Predicate<String> isLengthGt5 = (word) -> word.length() >= 5;

        // get the unique list of words having length greater than 5
        return wrdList.stream()
               .filter(isLengthGt5)
               .collect(Collectors.toSet());
    }

    // method to join all words in the list by a delimiting character ":-:"
    protected static String joinWords(@NotNull List<String> wrdList, String delimiter) {
        // join all words in the list by a delimiting character ":-:"
        // handle null pointer exception if delimiter is null
        return wrdList.stream()
                .filter(isWordNotNull)
                .collect(Collectors.joining(delimiter));
    }

    // method to group the list of words by their length
    // Return Type: Map<Integer, List<String>>
    protected static Map<Integer,List<String>> groupWordsByLength(@NotNull List<String> wrdList){
        // group the list of words by their length
        return wrdList.stream()
                .filter(isWordNotNull)
                .collect(Collectors.groupingBy(String::length));
    }

    // method to partition words by predicate if the length is greater than 5
    protected static Map<Boolean,List<String>> partitionWordsByLength(@NotNull List<String> wrdList){
        // partition words by predicate if the length is greater than 5
        return wrdList.stream()
               .collect(Collectors.partitioningBy(isLengthThan5));
    }


    



}
