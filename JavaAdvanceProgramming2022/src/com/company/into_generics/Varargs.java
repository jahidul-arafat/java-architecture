package com.company.into_generics;

/**
 * Write a method that takes variable number of arguments
 * */
public class Varargs {
    public static void main(String[] args) {
        // Let's have 3 fruit items
        String item1 ="Apple";
        String item2 ="Oranges";
        String item3 = "Pears";

        String[] itemList = {"A","B","C","D","E"};

        printShoppingList(item1,item2);
        printShoppingList(item1,item2,item3);
        printShoppingList(item1,item2,item3,item1,item2,item3);
        printShoppingList(itemList);
    }

//    public static void printShoppingList(String str1, String str2){
//
//        String strFmt = String.format("Into the Shopping Cart(2 args)\n-------\n%s\n%s",str1,str2);
//        System.out.println(strFmt);
//
//    }

    // overriding the method with 3 params
//    public static void printShoppingList(String str1, String str2, String str3){
//
//        String strFmt = String.format("Into the Shopping Cart(3 args)\n-------\n%s\n%s\n%s",str1,str2,str3);
//        System.out.println(strFmt);
//
//    }


    // overriding with an array of items
//    public static void printShoppingList(String[] args) {
//        System.out.println("Into the Shopping Cart(varargs)\n-----------------");
//        for (String item:args
//             ) {
//            System.out.println(item);
//
//        }
//    }

    // Better Solution- overriding the method with variable number of arguments
    public static void printShoppingList(String... args) {
        System.out.println("Into the Shopping Cart(varargs)\n-----------------");
        for (String item:args
        ) {
            System.out.println(item);

        }

    }




}
