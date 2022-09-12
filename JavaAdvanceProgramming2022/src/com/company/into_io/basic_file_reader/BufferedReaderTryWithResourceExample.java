package com.company.into_io.basic_file_reader;

import java.io.*;
import java.util.Scanner;

public class BufferedReaderTryWithResourceExample {
    public static void main(String[] args) {
        File sourceFile = new File("source_file.txt");

        try (BufferedReader bReader = new BufferedReader(new FileReader(sourceFile))) {
            String line;
            while ((line = bReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
