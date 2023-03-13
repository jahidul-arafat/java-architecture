package org.jarotball.ds;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CollectionsExercise {
    public void addToEndOfLinkedList(@NotNull LinkedList<Integer> numbers, int number){
        numbers.add(number);
    }

    public void addToStartOfLinkedList(@NotNull LinkedList<Integer> numbers, int number){
        numbers.addFirst(number);
    }

    public void removeItemFromTopOfStack(@NotNull Deque<Integer> stack) {
        stack.poll();
    }

    public void removeItemFromFrontOfQueue(@NotNull Queue<Integer> queue){
        queue.poll();

    }

    public void addItemToTreeSet(Set<String> set, String item){
        set.add(item);
    }


}
