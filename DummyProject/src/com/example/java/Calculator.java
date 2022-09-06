package com.example.java;

import java.util.Scanner;

public class Calculator {
    public static final String calcName = "DemoCalculator";
    private double input1;
    private double input2;
    Scanner scanner = new Scanner(System.in);

    public void userInputs() {

        System.out.print("Input_01: ");
        this.input1 = scanner.nextDouble();

        System.out.print("Input_02: ");
        this.input2 = scanner.nextDouble();
    }

    public void userInputsAsStringParsedToDouble() {
        System.out.println("Input_01: ");
        String input1_str = scanner.nextLine();
        this.input1 = Double.parseDouble(input1_str);

        System.out.println("Input_02: ");
        String input2_str = scanner.nextLine();
        this.input2 = Double.parseDouble(input2_str);

    }

    public double addition() {
        return this.input1 + this.input2;
    }
}
