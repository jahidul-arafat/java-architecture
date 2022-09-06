package com.example.java.domains;

import com.example.java.utilities.MathHelper;
import com.example.java.utilities.UtilityHelper;

public class CalculatorMod {
    // Class variable

    public static void main(String[] args) {

        CalculatorMod calc1 = new CalculatorMod();
        calc1.calculate();

        CalculatorMod calc2 =new CalculatorMod();
        calc2.calculate();

    }

    private void calculate() {
        DemoNestedClass dm = new DemoNestedClass();
        dm.greetMe("Jahidul Arafat");

        String s1 = UtilityHelper.getInput("Enter input_01: ");
        String s2 = UtilityHelper.getInput("Enter input_02: ");
        String op = UtilityHelper.getInput("Choose an Operator: (+ - * /): ");

        double result = 0;

        try {
            switch (op) {
                case "+" -> result = MathHelper.addValues(s1, s2);
                case "-" -> result = MathHelper.subtractValues(s1, s2);
                case "*" -> result = MathHelper.multiplyValues(s1, s2);
                case "/" -> result = MathHelper.divideValues(s1, s2);
                default -> System.out.println("Unrecognized operator");
            }
            System.out.println("The answer is: "+result);
        } catch (Exception e) {
            System.out.println("Number formatting exception: "+e.getMessage());
        }
    }

    // nested class
    class DemoNestedClass{
        private void greetMe(String prompt){
            System.out.println("Welcome "+ prompt);
        }
    }


}
