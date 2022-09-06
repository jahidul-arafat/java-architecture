package com.example.java.models;

public class Kalamata extends Olive{
    public Kalamata() {
        super(OliveName.KALAMATA,OliveColor.PURPLE,3);
    }

    @Override
    public String getOrigin() {
        return "Italy";
    }
}
