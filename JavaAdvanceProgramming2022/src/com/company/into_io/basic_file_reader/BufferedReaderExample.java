package com.company.into_io.basic_file_reader;

import java.io.*;

public class BufferedReaderExample {
    public static void main(String[] args) {
        File sourceFile = new File("source_file.txt");

        BufferedReader bReader = null;
        try {
            bReader = new BufferedReader(new FileReader(sourceFile));
            String line;
            while ((line = bReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
