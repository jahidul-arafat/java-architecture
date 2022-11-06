package org.codeclinic.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextLoader {
    // custom_method_1: get all the lines from the sample dataset and load this into a list<String>
    // must be a class method, should not be an Instance method
    // try to open the file from which we will read the lines
    /*
        Constraints
        -----------
        (a) Exception could happen while reading the lines
        (b) FileNotFound Exception could occur

        Hints
        ------
        (a) use try with resource block
        (b) bufferedRead with FileReader
     */

    public static List<String> parseLines(String fileName){
        List<String> linesList = new ArrayList<>();
        try(BufferedReader bfReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Boolean skipFirstLine = true;
            while ((line=bfReader.readLine())!=null){
                linesList.add(line);
            }


        } catch (Exception e) {
            System.out.println("Exception: "+ e.getMessage());
        }
        return linesList;
    }
}
