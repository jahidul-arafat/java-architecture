package com.company.into_io.basic_file_creation;

import java.io.File;
import java.io.IOException;

public class FileCreationExample {
    public static void main(String[] args) {
        File fileToBeCreated = new File("FileToBeCreated.txt");
        try {
            var isFileCreated = fileToBeCreated.createNewFile(); // returns a boolean value, not a file object
            System.out.println(String.format("File (%s) Creation status: %s", fileToBeCreated.getName(), isFileCreated));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
