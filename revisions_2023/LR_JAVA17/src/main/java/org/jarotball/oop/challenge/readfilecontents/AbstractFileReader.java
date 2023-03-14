package org.jarotball.oop.challenge.readfilecontents;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractFileReader {
    private final Path filePath;

    // Constructor
    public AbstractFileReader(String filePath) {
        this.filePath = Path.of(filePath);
    }

    //-------------------------------------------------------------------------------------------------------------\\
    // Custom Methods
    // Read the Lines inside the file and map individual line to the parseLine logic implemented by different sub-classes
    public List<String> readFile() throws IOException{
        return Files.lines(this.filePath)
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    public abstract String parseLine(String line);
//    {
//        // regex - [^0-9] means, match all the alphabets expect the numerics one and replace those with ""(nothing)
//        return line.replaceAll("[^0-9]","");
//    }


    //-------------------------------------------------------------------------------------------------------------\\
    // Getter and No-Setter
    public String getFilePath() {
        return filePath.toString();
    }
}
