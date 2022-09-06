package com.example.java.utilities;

import com.example.java.models.Olive;

import java.util.Iterator;
import java.util.List;

public class OlivePress implements Press {
    private int currentOil;

    public int getOil(List<Olive> oliveList) {
        int totalOil =currentOil;

        for (Olive currentOlive : oliveList) {
            totalOil += currentOlive.crush();
        }
        return totalOil;
    }

    @Override
    public void setOil(int oil) {
        this.currentOil = oil;

    }


}
