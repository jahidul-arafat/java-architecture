package com.example.java.models;

public abstract class Olive {
    // class variables
    //Define the olive types, to avoid typos
//    public static final String KALAMATA="kalamata";
//    public static final String HALAMATA="halamata";
//    public static final String JALAMATA="jalamata";
//    public static final String HULULUTA="hululuta";

    // instance variables
    private OliveName name;
    private OliveColor color;
    private int oil;

    //constructor-01: null_argument constructor
    //public Olive(){}

    //constructor-02: with_argument constructor
    public Olive(OliveName name, OliveColor color, int oil) {
        this.name = name;
        this.color = color;
        this.oil = oil;
    }

    // getter and setter method
    public OliveName getName() {
        return name;
    }

    public void setName(OliveName name) {
        this.name = name;
    }

    public OliveColor getColor() {
        return color;
    }

    public void setColor(OliveColor color) {
        this.color = color;
    }

    public int crush() {
        System.out.println("Ouch!!! .... crashing olive<"+ this.name+":: from "+ getOrigin()+ "> ...-> got "+ this.oil+" units oil");
        return oil;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    // part of abstract simulation
    public abstract String getOrigin(); // country its coming from // all the subclasses of Superclass<Olive> must have to implement this method.

    // printing the olive
    @Override
    public String toString() {
        String msg;

        msg = "Olive {" + "\n" +
                "name= " + this.name + "\n" +
                "color= " + this.color + "\n" +
                "oil= " + this.oil + "\n" +
                "}";
        return msg;

    }


}
