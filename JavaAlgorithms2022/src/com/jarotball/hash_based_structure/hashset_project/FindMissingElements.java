/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.hash_based_structure.hashset_project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Checking the Principles of Membership
 * Given two arrays, check if the items in the First Array is in the Second Array
 * If not, put those items into the missing list and return
 * */

public class FindMissingElements {
    public static void main(String[] args) {
        int[] first = {1,2,3,4};
        int[] second = {3,4,5,6};
        findMissingElements(first,second).forEach(System.out::println);

    }

    public static List<Integer> findMissingElements(int[] first, int[] second){
        // create a missing item list
        List<Integer> missingElementList = new ArrayList<>();

        // Put all the elements of Second Array into a HashSet
        HashSet<Integer> hashSetOfSecondArray = new HashSet<>();
        for (var itemSecond: second
             ) {
            hashSetOfSecondArray.add(itemSecond);
        }

        // Now, iterate through the elements of first array and crosscheck if that element exists in the SecondArray_HS
        for (var itemFirst:first
             ) {
            if (!hashSetOfSecondArray.contains(itemFirst)){
                // add these missing elements into a list/array
                missingElementList.add(itemFirst);
            }
        }

        return missingElementList;

    }
}
