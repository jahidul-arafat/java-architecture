package org.jarotball.functional_programming.custom_fp;

public class Application {
    public static void main(String[] args) {
        TriFunction<Integer,Integer,Integer,Integer> triFunc = (n1,n2,n3)-> n1+n2+n3+1;
        var output=triFunc.apply(10,20,30);
        System.out.println(output);

        NoArgFunction<String> noArgFunction = ()-> "Hello";
        System.out.println(noArgFunction.apply());
    }
}
