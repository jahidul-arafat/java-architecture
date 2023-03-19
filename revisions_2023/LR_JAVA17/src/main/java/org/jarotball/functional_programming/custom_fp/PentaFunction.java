package org.jarotball.functional_programming.custom_fp;

@FunctionalInterface
public interface PentaFunction<X,S,T,U,V,R> {
    R apply(X x, S s, T t, U u, V v);
}
