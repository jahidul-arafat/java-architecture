package org.jarotball.oop.challenge.modarray_inheritance;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ConditionArrayList extends ArrayList<Integer> {

    // Instance Attributes
    // Define a predicate i.e. condition to check if the number isOdd, isEven, isPositive, isNegative etc and add the number
    // in the ArrayList based on this condition
    Predicate<Integer> condition;

    // constructor
    // Constructor-01 -- Default Constructor
    public ConditionArrayList(Predicate<Integer> condition) {
        this.condition = condition;
    }

    // Constructor-02
    public ConditionArrayList(Predicate<Integer> condition,Integer... nums) {
        super(Arrays.stream(nums)
                .filter(condition)
                .collect(Collectors.toList()));
    }

    // Constructor-03
    public ConditionArrayList(@NotNull Collection<? extends Integer> c, Predicate<Integer> condition) {
        super(c.stream()
                .filter(condition)
                .collect(Collectors.toList()));
        this.condition=condition;
    }


    // overriding the superclass methods
    /*
     - void add(int index, Integer element)
     - boolean add(Integer element)
     - boolean addAll(Collection<? extends Integer> c)
     - boolean addAll(int index, Collection<? extends Integer> c)
     - Integer set(int index, Integer element)
     */
    @Override
    public void add(int index, Integer element) {
        if (isEligible(element)){
            super.add(Math.abs(index),element);
        }
    }

    @Override
    public boolean add(Integer element) {
        if (isEligible(element))
            return super.add(element);
        else
            return false;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends Integer> c) {
        return super.addAll(c.stream()
                .filter(this::isEligible)
                .collect(Collectors.toList()));
    }

    @Override
    public boolean addAll(int index, @NotNull Collection<? extends Integer> c) {
        return super.addAll(Math.abs(index), c.stream()
                .filter(this::isEligible)
                .collect(Collectors.toList()));
    }

    @Override
    public Integer set(int index, Integer element) {
        if (isEligible(element))
            return super.set(index, element);
        else {
            System.out.println(element + " doesn't meeting the condition");
            return Integer.MIN_VALUE;   //-2147483648
        }
    }

    private <Integer> boolean isEligible(int element){
        return condition.test(element);
    }

}
