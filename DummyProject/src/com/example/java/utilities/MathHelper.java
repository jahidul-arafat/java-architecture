package com.example.java.utilities;

public class MathHelper {
    public static double divideValues(String s1, String s2) {
        double in1 = Double.parseDouble(s1);
        double in2 = Double.parseDouble(s2);

        return in1 / in2;
    }

    public static double multiplyValues(String s1, String s2) {
        double in1 = Double.parseDouble(s1);
        double in2 = Double.parseDouble(s2);
        return in1 * in2;
    }

    public static double subtractValues(String s1, String s2) {
        double in1 = Double.parseDouble(s1);
        double in2 = Double.parseDouble(s2);
        return in1 - in2;
    }

    public static double addValues(String s1, String s2) {
        double in1 = Double.parseDouble(s1);
        double in2 = Double.parseDouble(s2);
        return in1 + in2;
    }
}
