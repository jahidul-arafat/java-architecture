package org.example.playground.filter_examples;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Playground {
    protected static List<String> getNCharLongWords(@NotNull List<String> words, Predicate<String> isLongerThanN) {
        return words.stream()
              .filter(isLongerThanN)
              .collect(Collectors.toList());
    }

    // StringBuilder only for single threaded scenario which doesnt require synchronization

    protected static String dynamicStringBuilder(){
        // define a string builder
        StringBuilder dynamicSB = new StringBuilder();

        // append multiple strings to the string builder
        dynamicSB.append("Hello");
        dynamicSB.append(" ");
        dynamicSB.append("World");
        dynamicSB.append(" ");
        dynamicSB.append("This");
        dynamicSB.append(" ");
        dynamicSB.append("is");
        dynamicSB.append(" ");
        dynamicSB.append("a");
        dynamicSB.append(" ");
        dynamicSB.append("string");
        dynamicSB.append(" ");
        dynamicSB.append("builder");
        dynamicSB.append(" ");
        dynamicSB.append("example");

        return dynamicSB.toString();
    }
}
