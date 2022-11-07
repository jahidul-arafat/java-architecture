package org.codeclinic.utility;

import org.json.JSONObject;

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

    public static JSONObject formatStringJSONtoJSON(String stringInJSONFormat){
        JSONObject jsonObject = null;
        jsonObject = new JSONObject(stringInJSONFormat);
        return jsonObject;

    }
}
