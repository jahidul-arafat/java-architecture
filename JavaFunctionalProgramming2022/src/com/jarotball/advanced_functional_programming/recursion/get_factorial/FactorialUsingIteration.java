package com.jarotball.advanced_functional_programming.recursion.get_factorial;

public class FactorialUsingIteration {
    public static void main(String[] args) {
        System.out.println(factorial(4));

    }

    public static Integer factorial(Integer x){
        Integer fact=1;
        Integer counter=1;
        while (counter<=x){
            System.out.print(String.format("i: %s, fact: (%s * %s)",counter,fact,counter));
            fact=fact*counter;
            System.out.println(" Output: "+fact);
            counter+=1;
        }
        return fact;
    }
}
