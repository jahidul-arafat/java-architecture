/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.hash_based_structure.count_elements;

import java.util.HashMap;

public class CountElements {
    public static void main(String[] args) {
        int[] demoList ={1,2,3,4,1,2,3,5,6,7};
        displayFreqOfEachElement(demoList);

    }

    public static void displayFreqOfEachElement(int[] demoList){
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for (var item:demoList
             ) {
            if (!freqMap.containsKey(item)){
                freqMap.put(item,1);
            } else {
                freqMap.put(item,freqMap.get(item)+1);
            }

        }
        freqMap.forEach((key,value)-> System.out.println("item/"+key+" : "+"count/"+value));
    }
}
