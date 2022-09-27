package com.jarotball.advanced_functional_programming.recursion.print_func;

/**
 *
 * output(expected): 3 2 1 1 2 3
 * output(for better understanding): (L1)3 (L1)2 (L1)1 done (L2)1 (L2)2 (L2)3
 * L1 - Line1
 * L2 - Line2
 * */
public class Simulator {
    public static void main(String[] args) {
        printFun(3);

    }

    public static void printFun(int n){
        if (n<1){
            System.out.printf("done ");
            return;
        }
        System.out.printf("(L1)%s ",n); // L1 - Line1
        printFun(n-1);
        System.out.printf("(L2)%s ",n); // L2 - Line2


    }
}
