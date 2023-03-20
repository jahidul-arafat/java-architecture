package org.jarotball.functional_programming.recursion;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * idx  0   1   2   3   4   5   6
 * FIB  0   1   1   2   3   5   8
 */
public class FiboSeries {
    // Class Attributes
    // For DP - Recursion and Memorization
    public static int[] fibMemo;

    // Fibonacci Series using Iteration
    @Contract(pure = true)
    public static @NotNull List<Integer> fib(Integer nthElement){
        Integer[] fibSum = new Integer[nthElement+1];
        for (int idx = 0; idx <= nthElement; idx++) {
            // base case
            if (idx==0) {
                fibSum[idx]=idx;
                continue;
            }
            if(idx==1 || idx==2) {
                fibSum[idx]=1;
                continue;
            }
            fibSum[idx]=fibSum[idx-1]+fibSum[idx-2];
        }
        return Arrays.asList(fibSum);
    }

    // Fibonacci Series using Basic Recursion
    public static int fibRec(int idx){
        if (idx==0) return 0;
        else if (idx==1||idx==2) return 1;
        else return fibRec(idx-1)+ fibRec(idx-2);
    }

    public static @NotNull List<Integer> fibByRec(int nthElement){
        Integer[] fibArray = new Integer[nthElement+1];
        for (int idx=0;idx<=nthElement;idx++){
            fibArray[idx]=fibRec(idx);
        }
        return Arrays.asList(fibArray);
    }

    // Fibonacci Series using Recursion and Memorization
    // Its called Dynamic Programming
    public static int fibByRecMemo(int idx){
        // idx=0
        if (idx==0){
            fibMemo[idx]=0;
            return 0;
        }

        // idx=1, idx=2
        if (idx==1||idx==2){
            fibMemo[idx]=1;
            return 1;
        }

        // index starts with nthElement i.e. 5
        // the fibMemo array is fill with all Zeros
        // Look for a idx and check whether already any operations done here; if not, go for it
        // else just return the value at that particular index
        if (fibMemo[idx]==0){
            fibMemo[idx]=fibByRecMemo(idx-1)+fibByRecMemo(idx-2);
            return fibMemo[idx];
        } else return fibMemo[idx];
    }

    public static void main(String[] args) {
        int nthElement=50;
        System.out.println("By For Loop");
        Long startTimeForLoop = System.nanoTime();
        List<Integer> fibList= fib(nthElement);
        System.out.println(fibList);
        Long stopTimeForLoop = System.nanoTime();
        System.out.format("For Loop Time: %s%n", (stopTimeForLoop-startTimeForLoop));

        System.out.println();

        System.out.println("By Recursion");
        Long startTimeRecursion = System.nanoTime();
        List<Integer> fibByRecList = fibByRec(nthElement);
        Long stopTimeRecursion = System.nanoTime();
        System.out.println(fibByRecList);
        System.out.format("For Recursion: %s%n", (stopTimeRecursion-startTimeRecursion));

        System.out.println();

        System.out.println("By DP - Recursion and Memorization");
        fibMemo = new int[nthElement+1];
        Arrays.fill(fibMemo,0);

        Long startTimeRecMemo = System.nanoTime();
        fibByRecMemo(nthElement);
        Long stopTimeRecMemo = System.nanoTime();

        Arrays.stream(fibMemo).forEach(n->System.out.format(" %s ",n));
        System.out.println();
        System.out.format("For RecMemo: %s%n", (stopTimeRecMemo-startTimeRecMemo));

        }
    }
