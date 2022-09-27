package com.jarotball.firstclass_functions.functional_programming_basics.greeting;

public class Simulator {
    public static void main(String[] args) {
        // Simulation_01 - Requires creating a class Named "HelloGreeting" which will implement the interface method
        Greeting grClass = new HelloGreeting();
        grClass.sayHello();

        // Alternative_01 - Without creating a class directly implement the interface in the main
        Greeting gr = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello World");
            }
        };
        gr.sayHello();

        // Alternative_02: Using Lambda
        // Greeting is a functional interface
        Greeting grFunc = ()->{
            System.out.println("Hello World From Function");
        };

        grFunc.sayHello();
    }
}
