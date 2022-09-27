package com.jarotball.firstclass_functions.functional_programming_basics.greeting_alternative;

public class Simulator {
    public static void main(String[] args) {
        Greeting<String, String> grFunc = (demoName)->"Hello "+ demoName+" !!";

        System.out.println(grFunc.sayHello("Jahidul Arafat"));
    }
}
