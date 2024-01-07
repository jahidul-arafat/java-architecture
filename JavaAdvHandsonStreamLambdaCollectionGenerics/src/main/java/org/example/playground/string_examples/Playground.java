/**
 * By Jahidul Arafat
 * Software & Cloud Solution Architect (AppDev and DevSecOps)
 * email: jahidapon@gmail.com, jahidul.arafat@oracle.com
 * Concept URL: https://www.javatpoint.com/string-pool-in-java
 */
package org.example.playground.string_examples;

import org.jetbrains.annotations.NotNull;

public class Playground {
    /*
    String vs StringBuilder vs StringBuffer

                    STRING          STRINGBUFFER       STRINGBUILDER

    Storage         String Pool     Heap                Heap
    Modifiable      Immutable   	Mutable           	Mutable
    Thread Safe     YES             YES                 NO
    Performance     FAST            VERY SLOW           FAST
     */


    protected static @NotNull Long StringBuilderExecutionTime() {
        // Start Time before executing the String Builder
        long startTime = System.currentTimeMillis();
        //System.out.println("Start Time: " + System.currentTimeMillis());

        // define a new StringBuilder
        StringBuilder sb = new StringBuilder("Jahid...");
        // iterate over a loop till 999 to append to the StringBuilder
        for (int i = 0; i < 99999999; i++) {
            sb.append(i); // Storing the data in HEAP
        }
        //System.out.println(sb.toString());
        return System.currentTimeMillis() - startTime;
    }

    protected static @NotNull Long StringBufferExecutionTime() {
        // Start Time before executing the String Builder
        long startTime = System.currentTimeMillis();
        //System.out.println("Start Time: " + System.currentTimeMillis());

        // define a new StringBuilder
        StringBuffer sBuff = new StringBuffer("Jahid...");
        // iterate over a loop till 999 to append to the StringBuilder
        for (int i = 0; i < 99999999; i++) {
            sBuff.append(i); // Storing the data in HEAP
        }
        //System.out.println(sBuff.toString());
        return System.currentTimeMillis() - startTime;
    }

    // HEAP - a special area in the computer's memory, where dynamically allocated objects are stored which are created with 'new' keyword
    // StringPool - a part of the HEAP to store string literals, i.e. "Hello" and its mechanism to optimize memory usage by reusing existing string literals.
    // str1==str2 // reference comparison not content comparison // check if the two references point to the same memory location
    // str1.equals(str2) // content comparison // check if actual characters in the strings are same
    protected static void StringPoolVsHeapExample() {
        // Create 2x String, one storing in the Special StringPool in the memory when next is storing in HEAP
        // HEAP refers to a regions in the computer's memory, where dynamically allocated objects are stored in the memory.
        // i.e. objects created with 'new' keywords are stored in HEAP
        // When StringPool is a specific area within the HEAP, where String literals i.e. "Hello" are stored.
        String strAtStringPool1 = "Hello"; // a Hello literal will be created in the StringPool
        String strAtStringPool2 = "Hello"; // no new String literal will be created in the StringPool, instead referenced to the exsiting "Hello" literal already in the memory

        // .intern place the string in the StringPool, thus avoiding new string creation, just referencing to the earlier literal "Hello"
        String strAtStringPool3_exception = new String("Hello").intern(); // though using keyword 'new', the intern keyword makes its place in the StringPool referencing to the earlier literal "Hello"

        String strAtHeap1 = new String("Hello");
        String strAtHeap2 = new String("Hello");
        System.out.println("strAtHeap1: "+strAtHeap1);
        System.out.println("strAtStringPool1: "+strAtStringPool1);
        System.out.printf("strAtStringPool1.equals(strAtStringPool2):%s%n", strAtStringPool1 == strAtStringPool2); // true // both point to the same String literal
        System.out.printf("strAtStringPool1==strAtHeap1: %s%n", strAtStringPool1 == strAtHeap1); // false // reference comparison not content comparison
        System.out.printf("strAtHeap1==strAtHeap2: %s%n", strAtHeap1 == strAtHeap2); // false // reference comparison not content comparison

        System.out.printf("strAtStringPool1==strAtStringPool3_exception: %s%n", strAtStringPool1.equals(strAtStringPool3_exception));

        /* print the memory location of strAtStringPool1 */
        System.out.println("strAtStringPool1[Hash]: " + System.identityHashCode(strAtStringPool1)); // 1450495309 // referenced to string literal "Hello" at digest "1450495309"
        System.out.println("strAtStringPool2[Hash]: " + System.identityHashCode(strAtStringPool2));// 1450495309 // referenced to string literal "Hello" "1450495309"; this is not the memory localtion.
        //System.out.println("strAtStringPool3_exception[Hash]: "+System.identityHashCode(strAtStringPool3_exception));// 1450495309
        // in Java there is no direct way to get the memory location of a String literal
        // instead you will have the digest i.e. hashCode() which is typically derived from the memory location of an object

        System.out.println("strAtHeap1[Heap]: " + System.identityHashCode(strAtHeap1)); // 1670782018
        System.out.println("strAtHeap2[Heap]: " + System.identityHashCode(strAtHeap2)); // 1706377736

        StringBuilder sb1 = new StringBuilder("He");
        sb1.append("llo");
        String sb1Str = sb1.toString().intern(); // will reference to string literal "Hello"

        StringBuilder sb2 = new StringBuilder("He");
        sb2.append("llo");
        System.out.println("sb1: " + sb1.toString());
        System.out.println("sb1Str: " + sb1Str);
        System.out.println("sb2: " + sb2.toString());

        System.out.printf("sb1[Hash]: %s%n", System.identityHashCode(sb1)); // 868693306
        System.out.printf("sb2[Hash]: %s%n", System.identityHashCode(sb2)); // 1746572565
        System.out.printf("sb1Str[Hash]: %s%n", System.identityHashCode(sb1Str)); // 868
        System.out.printf("strAtStringPool1==sb1Str: %s%n", strAtStringPool1 == sb1Str);
        System.out.printf("sb1==sb2: %s%n", sb1.toString() == sb2.toString());


    }


}
