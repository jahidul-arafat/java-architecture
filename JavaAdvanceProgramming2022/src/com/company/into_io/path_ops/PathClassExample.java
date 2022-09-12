package com.company.into_io.path_ops;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PathClassExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter File to be deleted: ");
        String fileToBeDeleted = sc.next();

        // convert the filename into file URL using the Path interface
        Path pathToFile = Path.of(fileToBeDeleted);

        // delete the file
        deleteTheFile(fileToBeDeleted, pathToFile);

        // get the metadata of the file
        extractFileMetaData(pathToFile);

    }

    private static void deleteTheFile(String fileToBeDeleted, Path pathToFile) {
        // try to delete the file, raise exception if the file not found
        try {
            Files.deleteIfExists(pathToFile);
        } catch (IOException e) {
            System.out.println(String.format("File<%s> doesn't exist", fileToBeDeleted));
            e.printStackTrace();
        }
    }

    private static void extractFileMetaData(Path pathToFile) {
        System.out.println(pathToFile.getFileName());
        System.out.println(pathToFile.getParent());
        System.out.println(pathToFile.getRoot());
        System.out.println(pathToFile.getFileSystem());
    }


}
