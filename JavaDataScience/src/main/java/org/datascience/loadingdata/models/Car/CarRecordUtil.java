package org.datascience.loadingdata.models.Car;

import java.util.Arrays;

public class CarRecordUtil {
    public static CarRecord parseCar(String dataString){
        var fields = Arrays.asList(dataString.split("\\s+")); // splitting by white space
        try {
            Float mpg = Float.parseFloat(fields.get(0).trim());
            Integer numberOfCylinders = Integer.parseInt(fields.get(1).trim());
            Float displacement = Float.parseFloat(fields.get(2).trim());
            Float weight = Float.parseFloat(fields.get(4).trim());
            Integer year = Integer.parseInt(fields.get(6).trim());
            Integer origin = Integer.parseInt(fields.get(7).trim());

            return new CarRecord(mpg, numberOfCylinders,displacement,weight,year,origin);
        }  catch (Exception e){
            System.out.println("Exception: "+ e.getMessage());
            return null; // in the case of missing values
        }

    }
}
