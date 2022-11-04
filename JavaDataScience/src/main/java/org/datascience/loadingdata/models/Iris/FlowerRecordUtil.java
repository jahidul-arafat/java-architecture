package org.datascience.loadingdata.models.Iris;

import java.util.Arrays;

public class FlowerRecordUtil {
    public static FlowerRecord parseFlower(String record){
        var fields = Arrays.asList(record.split(","));

        try {
            Double sepalLength = Double.parseDouble(fields.get(0).trim());
            Double sepalWidth = Double.parseDouble(fields.get(1).trim());
            Double petalLength = Double.parseDouble(fields.get(2).trim());
            Double petalWidth = Double.parseDouble(fields.get(3).trim());
            String species  = fields.get(4).trim();

            return new FlowerRecord(sepalLength,sepalWidth,petalLength,petalWidth,species);
        } catch (Exception e){
            System.out.println("Exception: "+ e.getMessage());
            return null;
        }

    }
}
