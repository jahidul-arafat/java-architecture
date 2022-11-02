package org.datascience.loadingdata.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TextLoader {
    // custom method01: get all the lines from the sampledata and load this into a list<String>
    // class method
    public static List<String> parseLines(String filename){
        // create a placeholder i.e. a List<String> to add of the lines you read from the file
        List<String> lines = new ArrayList<>();

        // try to open the file from which we read the lines
        /*
            Constraints
            -----------
            1. Exception could happen while readling the line

            Hints
            -----
            1. Use Try with resource block
            2. BufferedRead with the FileReader
         */

        try(BufferedReader bfReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line= bfReader.readLine())!=null){
                lines.add(line);
            }

        } catch (Exception e){
            System.out.println("Exception: "+ e.getMessage());
        }

        return lines;
    }
}
