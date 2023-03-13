package org.jarotball.ds;

import java.util.*;

public class TreeSetExamples {
    public static void main(String[] args) {
        Set<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder());
        treeSet.add(1);
        treeSet.add(300);
        treeSet.add(47);
        treeSet.add(6);
        System.out.println(treeSet);
        treeSet.add(6);
        System.out.println(treeSet);

        Set<String> wordSet = new TreeSet<>(Comparator.comparing(String::length));
        wordSet.add("tiger");
        wordSet.add("giraffe");
        wordSet.add("bear");
        System.out.println(wordSet);
        wordSet.add("wolf");
        System.out.println(wordSet);
        wordSet.remove("giraffe");
        System.out.println(wordSet);



    }
}
