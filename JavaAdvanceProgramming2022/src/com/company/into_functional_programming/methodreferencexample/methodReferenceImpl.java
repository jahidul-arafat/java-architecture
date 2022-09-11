package com.company.into_functional_programming.methodreferencexample;

public class methodReferenceImpl {
    public static void main(String[] args) {
        Square s = new Square(4);

        // Lambda implementation
        // Short it with "Method Reference"
//        Shape shape = (Square item) -> {
//            return item.calculateArea();
//        };

        // Solution: Method Reference
        Shape shape = Square::calculateArea;

        System.out.println("Area: "+ shape.getArea(s));

    }



}
