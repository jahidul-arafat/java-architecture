package org.codeclinic.utility;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVLoader {
    public static List<CSVRecord> parseCSV(String filename){
        List<CSVRecord> recordList = new ArrayList<>();
        try(Reader reader = new FileReader(filename)) {
            Iterable<CSVRecord> recordsIterable = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            for (CSVRecord record: recordsIterable
                 ) {
                recordList.add(record);
            }
        } catch (Exception e){
            System.out.println("Exception: "+ e.getMessage());
        }
        return recordList;
    }
}
