package com.company.into_functional_programming.lambdaexample;

public class GreetingMsgImp {
    public static void main(String[] args) {
        GreetingMessage gm = new GreetingMessage() {
            @Override
            public void greet(String name) {
                System.out.println("Hello "+name);
            }
        };

        gm.greet("Arafat");

        GreetingMessage gm2 = (String name) -> {
            System.out.println("Hello "+name);
        };

        gm2.greet("Jahidul");

        MessagePrinter mp = () -> {
            System.out.println("This is an implementation message");
        };

        mp.printMessage();


    }
}
