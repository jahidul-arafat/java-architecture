package org.codeclinic.utility;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AuxiliaryUtils {
    public static List<String> getFileNamesFromDir (String targetDirectory){
        var files = Arrays.stream(new File(targetDirectory).listFiles()).toList();
        return files
                .stream()
                .map(file -> file.getName())
                .collect(Collectors.toList());
    }
}
