package com.example.java;

import java.util.Scanner;

public class SwitchStrings {
    // Class variable

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a month [1-12]: ");
        String input = scanner.nextLine();
        int monthNumber = Integer.parseInt(input);

        switch (monthNumber){
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            default:
                System.out.println("XXXXX-YY-ZZ");
        }


    }
}
