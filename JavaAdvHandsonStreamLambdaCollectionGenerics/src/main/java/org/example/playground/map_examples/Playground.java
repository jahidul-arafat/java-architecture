package org.example.playground.map_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Playground {
    public static void main(String[] args) {
        // an array of integers
        // int-> primitive data type-> Default value is O -> non-nullable
        // Integer -> Object Data type -> is a wrapper class for primitive data type 'int' -> Default value is 'null' -> nullable -> additional memory overhead:: cost of unboxing
        Integer[] numArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> numList = new ArrayList<>(Arrays.asList(numArray)); // mutable List
        numList.add(100); // mutable List
        System.out.println(numList);

        // By Jahidul Arafat, Solution Architect (AppDev and DevOps)
        // Example: Loop Unrolling
        // Question: As a Java Developer, do you really need to explicitly request Loop Unrolling? -> NO
        // Solution: JVM is responsible for performance optimization, including loop unrolling, during JIT compilation phase.
        // JVM makes this decision based on the runtime profiling information. So Loop unrolling doesnt need to be explicitly mentioned, JVM does that part for you.
        /*
        Benefits:
        - Reduce Loop Control Overhead
        - Improve Instruction-Level Parallelism

        Challenges
        - Tradeoff between Reduced Loop Control Overhead + improved performance VS increases the size of the compiled code.

         */
        // define an empty array of size 10
        Integer[] intArray = new Integer[10];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i;
        }
        System.out.println(Arrays.asList(intArray));

        Integer[] intArrayUnrolling = new Integer[10];
        for (int i = 0; i < intArrayUnrolling.length; i+=2) {
            intArrayUnrolling[i] = i;
            intArrayUnrolling[i+1] = i+1; // Loop Unrolling
        }
        System.out.println(Arrays.asList(intArrayUnrolling));
    }
}
