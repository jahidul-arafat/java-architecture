package com.example.java.models;

public class Halamata extends Olive{
    public Halamata(){
        super(OliveName.HALAMATA, OliveColor.GREEN,5);
    }

    @Override
    public String getOrigin() {
        return "Greece";
    }
}
