package com.example.java.domains;

import com.example.java.models.*;
import com.example.java.utilities.OlivePress;
import com.example.java.utilities.Press;

import java.util.ArrayList;
import java.util.List;

/**
 * This is an <b>olive press</b> application, and its job is to <i>press olives</i>
 * */
public class OliveMain {
    /**
     * The main method
     * @param args an array of String values
     * */


    // Class variable


    public static void main(String[] args) {
        System.out.println("Into the Olive Factory");

        List<Olive> oliveList = new ArrayList<>();

        Olive olive1 = new Kalamata();
        Olive olive2 = new Halamata();
        Olive olive3 = new Jalamata();
        Olive olive4 = new Hululuta();
        //Olive olive5 = new Olive();

        oliveList.add(olive1);
        oliveList.add(olive2);
        oliveList.add(olive3);
        oliveList.add(olive4);
        //oliveList.add(olive5);

        Press press = new OlivePress();
        press.setOil(5);
        int totalOil = press.getOil(oliveList);
        System.out.println("Total oil <after pressing>: "+ totalOil);

//        Press p2 = new Press() {
//            @Override
//            public int getOil(List<Olive> oliveList) {
//                return 0;
//            }
//
//            @Override
//            public void setOil(int oil) {
//
//            }
//        }


    }

}
