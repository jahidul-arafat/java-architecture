package org.jarotball.basics;

import org.jarotball.ds.ArrayExercise;

import java.util.Arrays;
import java.util.List;


public class HelloWorld {

    public static void main(String[] args) {
        ArrayExercise arrayExercise = new ArrayExercise();
        String[] input= {"hello", "apple", "hello", "jahid", "functional", "programming", "is", "cool"};
        arrayExercise.arrayToUpperCase(input);
        System.out.println(Arrays.toString(input));
        List l=List.of(1,2,3,"test");
        System.out.println(l.get(l.size()-1));
    }
}
