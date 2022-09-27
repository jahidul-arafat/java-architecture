package com.jarotball.advanced_functional_programming.recursion.get_factorial;

public class FactorialUsingRecursion {
    public static void main(String[] args) {
        Integer num =4;
        System.out.println(String.format("%s! = %s",num,factorial(num)));

    }

    /**
     *
     * factorial(4)
     * 4* factorial(3) -> 3* factorial(2) -> 2* factorial(1) -> 1 * factorial(0)
     *                                                          1*1=1
     *                                       2*1=2
     *                    3*2=6
     * 4*6
     *
     *
     * */
    public static Integer factorial(Integer n){
        // base case or stopping condition
        if (n!=0){
            //System.out.println(String.format("n=%s",n));
            return n*factorial(n-1); // recursive call
        } else {
            return 1;
        }

    }
}
