package org.jarotball.ds;

public class ArrayExercise {
    // Convert the input array elements into uppercase
    // Even if you dont define any constructor, an empty constructor is automatically created
    public void arrayToUpperCase(String[] input){
        for (int i=0;i<input.length;i++){
            input[i]=input[i].toUpperCase();
        }
    }

    public void incrementArray(int[] input){
        for (int i=0;i<input.length;i++){
            input[i]=input[i]+1;
        }
    }
}
