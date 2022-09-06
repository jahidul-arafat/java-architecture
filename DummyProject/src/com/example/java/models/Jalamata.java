package com.example.java.models;

public class Jalamata extends Olive{
    public Jalamata(){
        super(OliveName.JALAMATA, OliveColor.BLACK,7);
    }

    @Override
    public String getOrigin() {
        return "Singapore";
    }
}
