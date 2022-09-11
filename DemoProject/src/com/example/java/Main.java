package com.example.java;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello World ...");
        var unsignedInt = Integer.parseUnsignedInt("3000000000");
        System.out.println("Parsed Signed Integer: " + unsignedInt);

        System.out.println("Result: "+ Integer.divideUnsigned(unsignedInt,2));


    }
}