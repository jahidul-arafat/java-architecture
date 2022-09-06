package com.example.java.utilities;

import java.util.Scanner;

public class UtilityHelper {
    public static String getInput(String header) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(header);
        return scanner.nextLine();

    }
}
