package org.datascience.loadingdata.models.Grocery;

import org.apache.commons.csv.CSVRecord;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class GroceryRecordUtil {
    public static GroceryRecord parseGroceryItem(CSVRecord record){
        try {
            String memberNumber = record.get("Member_number");
            //Date dateOfPurchase = new SimpleDateFormat("dd-MM-yyyy").parse(record.get("Date"));
            String dateOfPurchase = record.get("Date");
            String itemDescription = record.get("itemDescription");

            return new GroceryRecord(memberNumber, dateOfPurchase, itemDescription);

        } catch (Exception e) {
            System.out.println("Exception: "+ e.getMessage());
            return null;
        }
    }

    public static Map<String, Long> sortByValue(Map<String,Long> unsortedMemberPurchasedItemCountMap){
        var output= unsortedMemberPurchasedItemCountMap
                .entrySet()
                .stream()
                .sorted((mem1,mem2)-> mem1.getValue().compareTo(mem2.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1,e2)-> e2,
                        LinkedHashMap::new
                ));

        return output;

    }



}
