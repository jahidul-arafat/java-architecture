package org.codeclinic.problems.prb4_manufacture.utils;

import org.codeclinic.problems.prb4_manufacture.models.ManufactureRecord;

import java.util.List;
import java.util.stream.Collectors;

public class Service {
    public static List<Integer> getPulsometers(List<ManufactureRecord> manufactureRecordList){
        return manufactureRecordList
                .stream()
                .map(ManufactureRecord::getPulsometer)
                .collect(Collectors.toList());
    }

    public static List<Double> getEngineEff(List<ManufactureRecord> manufactureRecordList){
        return manufactureRecordList
                .stream()
                .map(ManufactureRecord::getEngineeff)
                .collect(Collectors.toList());
    }

    public static List<Integer> getRed(List<ManufactureRecord> manufactureRecordList){
        return manufactureRecordList
                .stream()
                .map(ManufactureRecord::getRed)
                .collect(Collectors.toList());
    }

    public static List<Integer> getBlue(List<ManufactureRecord> manufactureRecordList){
        return manufactureRecordList
                .stream()
                .map(ManufactureRecord::getBlue)
                .collect(Collectors.toList());
    }

    public static List<Integer> getGreen(List<ManufactureRecord> manufactureRecordList){
        return manufactureRecordList
                .stream()
                .map(ManufactureRecord::getGreen)
                .collect(Collectors.toList());
    }

}
