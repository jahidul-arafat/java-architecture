package com.jarotball.preinit.optimize_a_sample_algorithm;

/**
 * Find Maximum of two numbers num1 and num2
 */

public class AlgorithmExample {

    public static void main(String[] args) {
        System.out.println(findMaximumOptimizedTernary(1, 2, 3));
        System.out.println(findMaximumOptimizedTernary(8, 8, 1));
        System.out.println(findMaximumOptimizedTernary(3, 2, 1));
        System.out.println(findMaximumOptimizedTernary(1, 1, 9));
        System.out.println(findMaximumOptimizedTernary(1, 9, 0));
    }

    /**
     * Returns the maximum of three numbers.
     * This method is not optimized. See findMaximumOptimized() and findMaximumOptimizedTernary
     *
     * @param num1 First input
     * @param num2 Second input
     * @param num3 Third input
     * @return the maximum number
     *
     *
     * */
    private static int findMaximumBasic(int num1, int num2, int num3) {
        if (num1 > num2) {
            if (num1 > num3 || num1 == num3) {
                return num1;
            }
        }
        if (num2 > num3) {
            return num2;
        }
        return num3;
    }

    private static int findMaximumOptimizedTernary(int num1, int num2, int num3) {
        int tempMax=num1;
        tempMax = num2>tempMax?num2:tempMax;
        tempMax = num3>tempMax?num3:tempMax;
        return tempMax;
    }

    private static int findMaximumOptimized(int num1, int num2, int num3){
        int tempMax=num1;
        if (num2>tempMax){
            tempMax=num2;
        }
        if (num3> tempMax){
            tempMax=num3;
        }
        return tempMax;

    }


}
