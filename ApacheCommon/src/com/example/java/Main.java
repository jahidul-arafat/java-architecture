package com.example.java;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        File sourceFile = new File("files/demoFile.txt");
        File targetFile = new File("files/targetFile.txt");

        try {
            FileUtils.copyFile(sourceFile,targetFile);
            System.out.println("File Copied!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
