package org.jarotball.oop.challenge.modarray_inheritance;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class OddArrayList extends ArrayList<Integer> {

    // constructor
    // Constructor-02
    public OddArrayList(Integer... nums) {
        super(Arrays.stream(nums)
                .filter(OddArrayList::isOdd)
                .collect(Collectors.toList()));
    }

    public OddArrayList(@NotNull Collection<? extends Integer> c) {
        super(c.stream()
                .filter(OddArrayList::isOdd)
                .collect(Collectors.toList()));
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
        if (isOdd(element)){
            super.add(Math.abs(index),element);
        }
    }

    @Override
    public boolean add(Integer element) {
        if (isOdd(element))
            return super.add(element);
        else
            return false;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends Integer> c) {
        return super.addAll(c.stream()
                .filter(OddArrayList::isOdd)
                .collect(Collectors.toList()));
    }

    @Override
    public boolean addAll(int index, @NotNull Collection<? extends Integer> c) {
        return super.addAll(Math.abs(index), c.stream()
                .filter(OddArrayList::isOdd)
                .collect(Collectors.toList()));
    }

    @Override
    public Integer set(int index, Integer element) {
        if (isOdd(element))
            return super.set(index, element);
        else {
            System.out.println(element + " is not odd");
            return Integer.MIN_VALUE;   //-2147483648
        }
    }

    private static <Integer> boolean isOdd(int element){
        return Math.abs(element)%2==1;
    }

}
