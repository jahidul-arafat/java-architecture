package org.jarotball.oop.challenge.modarray_inheritance;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class Simulator {
    // A common function
    public static void addRandomNumber(@NotNull ArrayList<Integer> list){
        Random random = new Random();
        int originalSize = list.size();
        int number = random.nextInt(10000);

        // check if the "list" is an instanceof ConditionArrayList
        // If so, cast the list to ConditionArrayList and use its unique functionality "isEligible"
        if (list instanceof ConditionArrayList){
            ConditionArrayList conditionArrayList = (ConditionArrayList) list;
            while (!conditionArrayList.isEligible(number)){
                number = random.nextInt(10000);
            }
        }
        list.add(number);
//        while (list.size()!=originalSize+1){
//            list.add(random.nextInt(10000));
//        }

    }
    public static void main(String[] args) {
        // ModArrayList
        System.out.println("ModArrayList");
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
        System.out.println("Odd Array List");
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
        System.out.println("regular Array List");
        ArrayList<Integer> arrayList = new ArrayList<>(List.of(1,2,3,4,5,6,7,9,-13));
        addRandomNumber(arrayList);
        System.out.println(arrayList);
        System.out.println(arrayList.size());


        // ConditionArrayList
        System.out.println("ConditionArrayList");
        Predicate<Integer> isEven = (number)-> Math.abs(number)%2==0;
        ConditionArrayList conditionArrayList= new ConditionArrayList(isEven,List.of(1,2,3,4,5,6,7,9,-13));
        System.out.println(conditionArrayList);

        conditionArrayList.add(100);
        conditionArrayList.set(1,1001);
        System.out.println(conditionArrayList);
        addRandomNumber(conditionArrayList);
        System.out.println(conditionArrayList);

        // ConditionArrayList
        // Testing CompileTime Polymorphism
        Predicate<Integer> divisibleByThree= (number)-> Math.abs(number)%3==0;
        System.out.println("ConditionArrayList - Compile Time Polymorphism");
        ArrayList<Integer> arrayList1 = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,141,15));
        ConditionArrayList conditionArrayList1 = new ConditionArrayList(divisibleByThree,arrayList1);
        System.out.println(conditionArrayList1);


    }


}
