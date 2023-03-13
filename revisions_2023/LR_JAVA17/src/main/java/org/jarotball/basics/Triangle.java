package org.jarotball.basics;

public class Triangle {

    // class attributes
    static int numOfSides=3;

    // instance attributes
    private double base, height, sideLength1, sideLength2, sideLength3;

    // constructor
    public Triangle(double base, double height, double sideLength1, double sideLength2, double sideLength3) {
        this.base = base;
        this.height = height;
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
        this.sideLength3 = sideLength3;
    }

    // custom methods - Instance
    // 01. findArea()
    public double findArea(){
        return (this.base * this.height)/2;
    }

    public static void forOnlyTriangleClass(){
        System.out.println("Triangle Class Member");

    }

    // getter and setter
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSideLength1() {
        return sideLength1;
    }

    public void setSideLength1(double sideLength1) {
        this.sideLength1 = sideLength1;
    }

    public double getSideLength2() {
        return sideLength2;
    }

    public void setSideLength2(double sideLength2) {
        this.sideLength2 = sideLength2;
    }

    public double getSideLength3() {
        return sideLength3;
    }

    public void setSideLength3(double sideLength3) {
        this.sideLength3 = sideLength3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
                ", height=" + height +
                ", sideLength1=" + sideLength1 +
                ", sideLength2=" + sideLength2 +
                ", sideLength3=" + sideLength3 +
                '}';
    }
}
