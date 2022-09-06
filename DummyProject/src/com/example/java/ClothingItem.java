package com.example.java;

public class ClothingItem {
    public String type;
    public static final String storeName = "DemoStore";

    public void displayItem(){
        System.out.println("This is a "+ this.type);
    }
}
