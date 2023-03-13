package org.jarotball.oop.challenge.modarray_inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModArrayList<E> extends ArrayList<E> {
    @Override
    public E get(int index) {
        int validIndex = Math.abs(index) % super.size();
        return super.get(validIndex);
    }
}
