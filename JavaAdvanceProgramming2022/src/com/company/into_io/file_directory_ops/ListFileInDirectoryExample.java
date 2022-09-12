package com.company.into_io.file_directory_ops;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

/**
 * List files in a directory or create a new directory
 */
public class ListFileInDirectoryExample {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // create a new directory
        //createDirectory("Enter directory name to be created: ");

        // list specific file types or names from a directory
        FilenameFilter filterOnlyFiles = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String fileName) {
                return fileName.contains(".");
            }
        };

        // list files in a directory and store it into an array contentList
        extractFilesFromDirectory("Extracting files from directory: ",filterOnlyFiles);


    }

    private static void createDirectory(String prompt) {
        System.out.print(prompt);
        String directoryToBeCreated = sc.next();
        var isDirectoryCreated =new File(directoryToBeCreated).mkdir(); // create the directory
        String result = isDirectoryCreated == true?"Directory Created Successfully":"Failed";
        System.out.println(result);
    }

    private static void extractFilesFromDirectory(String prompt, FilenameFilter filterOnlyFiles) {
        System.out.print(prompt);
        String directoryName = sc.next();
        try {
            String[] contentList = new File(directoryName).list(filterOnlyFiles);
            for (String item : contentList
            ) {
                System.out.println(item);
            }
        } catch (Exception e) {
            System.out.println(String.format("Directory <%s> doesn't exist",directoryName));
            //e.printStackTrace();
        }
    }
}
