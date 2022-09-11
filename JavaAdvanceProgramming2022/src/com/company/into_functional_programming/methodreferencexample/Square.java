package com.company.into_functional_programming.methodreferencexample;

public class Square {

    // class variable

    // encapsulation
    // object variable
    private int sideLength;

    // constructor
    public Square(int sideLength) {
        this.sideLength = sideLength;

    }

    // object method
    public int calculateArea(){
        return sideLength*sideLength;
    }


    // getter and setter
    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }
}
