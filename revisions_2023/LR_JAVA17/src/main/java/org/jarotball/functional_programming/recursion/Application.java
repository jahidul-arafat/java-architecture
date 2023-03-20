package org.jarotball.functional_programming.recursion;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Application {
    public static Integer factorialIterative(int factorialVal){
        var fact=1;
        var counter=1;
        while (counter<=factorialVal){
            fact=fact*counter;
            counter+=1;
        }
        return fact;
    }

    @Contract(pure = true)
    public static @NotNull Integer factorialRecursive(int n){
        if (n<=1)       // base case // stopping condition
            return 1;
        else
            return n*factorialRecursive(n-1);
    }

    // Print a Series of number with Recursive Java Method
    public static void printFun(int test){
        // base case // stopping condition
        if (test==0)
            return;
        else {
            System.out.format("%s ",test);
            printFun(test-1);
            System.out.format("%s ",test);
        }
    }

    // Sum a series of numbers with Java recursion
    public static long sumOfAllNumbers(long number){
        // base case
        if (number<=1)
            return  number;
        else {
            return number+sumOfAllNumbers(number-1);
        }
    }

    // Fibonacci Series
    // 0 1 1 2 3 5
    // using iteration
    public static void fibonacciIterative(long nLength){
        int a=0,b=1,next=0;
        System.out.format("%s , %s",a,b);
        int counter=2;
        // first nLength fibonacci series
        while (counter<nLength){
            next=a+b;
            System.out.format(", %s", next);

            // swap
            a=b;
            b=next;

            counter+=1;
        }
    }

    // Using recursion
    public static long fibonacci(long nthElement){
        if (nthElement<=1) return nthElement;
        return fibonacci(nthElement-1)+ fibonacci(nthElement-2);
    }



    public static void main(String[] args) {
        System.out.println(factorialIterative(5));
        System.out.println(factorialRecursive(5));
        printFun(3);
        System.out.println();
        System.out.println(sumOfAllNumbers(6));
        fibonacciIterative(10);
        System.out.println();
        System.out.println(fibonacci(8));

    }
}
