package org.jarotball.oop.challenge.modarray_inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class simulator {
    // A common function
    public static void addRandomNumber(ArrayList<Integer> list){
        Random random = new Random();
        int originalSize = list.size();
        while (list.size()!=originalSize+1){
            list.add(random.nextInt(10000));
        }

    }
    public static void main(String[] args) {
        // ModArrayList
        ModArrayList<Integer> list = new ModArrayList();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list);
        list.addAll(List.of(1,2,3,4));
        System.out.println(list);

        System.out.println(list.get(0));
        System.out.println(list.get(7));    //  default behavior override

        // OddArrayList
        OddArrayList oddArrayList = new OddArrayList(List.of(1,2,3,4,5,6,7,9,-13));
        System.out.println(oddArrayList);
        oddArrayList.addAll(List.of(10,20,30,40,-99,100));
        System.out.println(oddArrayList);
        oddArrayList.add(21);
        oddArrayList.add(1,20);
        oddArrayList.add(1,101);

        addRandomNumber(oddArrayList);

        System.out.println(oddArrayList);
        System.out.println(oddArrayList.size());

        // Regular ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>(List.of(1,2,3,4,5,6,7,9,-13));
        addRandomNumber(arrayList);
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        System.out.println(Integer.MIN_VALUE);


        // ConditionArrayList
        Predicate<Integer> isOdd = (number)-> Math.abs(number)%2==1;
        ConditionArrayList conditionArrayList= new ConditionArrayList(List.of(1,2,3,4,5,6,7,9,-13),isOdd);
        System.out.println(conditionArrayList);

        conditionArrayList.add(100);
        conditionArrayList.set(1,1001);
        System.out.println(conditionArrayList);
        addRandomNumber(conditionArrayList);
        System.out.println(conditionArrayList);


    }


}
