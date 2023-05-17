package org.jarotball.bufferoverflow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SafeFunction {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] buffer = new char[8];
        try {
            reader.read(buffer, 0, buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(buffer);

    }
}
