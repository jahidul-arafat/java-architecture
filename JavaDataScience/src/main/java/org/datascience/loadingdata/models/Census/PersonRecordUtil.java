package org.datascience.loadingdata.models.Census;

import java.util.Arrays;

public class PersonRecordUtil {
    public static PersonRecord parsePerson(String dataString){
        var fields = Arrays.asList(dataString.split(","));
        try {
            Integer age = Integer.parseInt(fields.get(0));
            String employmentStatus = fields.get(1).trim(); // trim any unnecessary white spaces
            String education = fields.get(3).trim();

            return new PersonRecord(age, employmentStatus, education);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
