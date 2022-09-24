package com.jarotball.firstclass_functions.custom_functional_programming_interfaces;

public class SimulatorMain {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> demoTriFunc01 = (x,y,z)-> x+y+z+1;
        System.out.println(demoTriFunc01.apply(1,2,3));

        NoArgFunction<String> demoNoArgFunc01 = ()-> "Hello";
        System.out.println(demoNoArgFunc01.apply());

    }


}
