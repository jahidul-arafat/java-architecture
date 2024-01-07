package org.example.playground.string_examples;

import static org.example.playground.string_examples.Playground.StringBufferExecutionTime;
import static org.example.playground.string_examples.Playground.StringBuilderExecutionTime;

public class Main {
    public static void main(String[] args) {
        // Testing which one is faster: StringBuilder or StringBuffer
        // StringBuilder supposed to be faster than StringBuffer
        // Both Storing data in Heap - at a special storage in computer's memory, where dynamically allocated objects are stored which are created with 'new' keyword.'
        //System.out.printf("SBuffer[Total Time]: %sms%n", StringBufferExecutionTime());
        //System.out.printf("SBuilder[Total Time]: %sms%n", StringBuilderExecutionTime());

        // Testing how the String literals and Dynamically Allocated Memories using 'new' keyword play the role
        // and which one is more optimized avoiding redundant string literal creation
        // Example String literal: "Hello"
        Playground.StringPoolVsHeapExample();

    }
}
