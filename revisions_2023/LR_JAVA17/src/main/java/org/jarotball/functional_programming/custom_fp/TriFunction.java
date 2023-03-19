package org.jarotball.functional_programming.custom_fp;

@FunctionalInterface
public interface TriFunction<T,U,V,R> {
    R apply(T t, U u, V v);
}
