package com.example.java.models;

public enum OliveName {
    KALAMATA("kalamata"),
    HALAMATA("halamata"),
    JALAMATA("jalamata"),
    HULULUTA("hululuta");

    private String name;

    OliveName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
